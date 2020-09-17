package cn.com.csii.controller;

import cn.com.csii.domain.SysLog;
import cn.com.csii.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class LogAop {
    private Date startTime;
    private long executionTime;
    private Class clazz;
    private Method method;
    private String url;
    private String ip;
    private String username;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private SysLogService sysLogService;
//2 visitTime timestamp 访问时间
//3 username VARCHAR2 操作者用户名
//4 ip VARCHAR2 访问ip
//5 url VARCHAR2 访问资源url
//6 executionTime int 执行时长
//7 method VARCHAR 访问方法
    @Pointcut("execution(* cn.com.csii.controller.*.*(..))")
    private void pt1(){}

//     两种使用切入点表达式的方法
//    @Before(value = "execution(* cn.com.csii.controller.*.*(..))")
    @Before("pt1()")
    public void BeforeDo(JoinPoint jp) throws Exception{
        //获取访问时间
        startTime = new Date();
        //获取访问的类
        clazz = jp.getTarget().getClass();

        //获取访问的成员方法
        String methodname = jp.getSignature().getName();
        Object[] args = jp.getArgs();
        if (args ==null || args.length==0){
            method = clazz.getMethod(methodname);
        }else {
            Class[] clazzs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                clazzs[i] = args[i].getClass();
            }
            method = clazz.getMethod(methodname,clazzs);
        }

    }


    @After("pt1()")
    public void AfterDo(JoinPoint jp) throws Exception{
        //获取访问时间
        executionTime = new Date().getTime()-startTime.getTime();
        System.out.println(startTime);
        System.out.println(executionTime);

        //获取url
        RequestMapping clazzAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
        if (clazzAnnotation!=null){
            String[] classValue = clazzAnnotation.value();
            RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
            if (methodAnnotation != null){
                String[] methodValue = methodAnnotation.value();
                url = classValue[0] + methodValue[0];
            }

        }
        //获取IP地址
        ip = request.getRemoteAddr();

        //获取操作用户:使用security获取
        SecurityContext context = SecurityContextHolder.getContext();
        User user = (User) context.getAuthentication().getPrincipal();
        String username = user.getUsername();
        //获取用户方法二
        request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");

        SysLog sysLog = new SysLog();
        sysLog.setVisitTime(startTime);
        sysLog.setExecutionTime(executionTime);
        sysLog.setIp(ip);
        sysLog.setUrl(url);
        sysLog.setUsername(username);
        sysLog.setMethod("[类名]"+ clazz.getName() + "[方法名]" + method.getName());

         sysLogService.saveLog(sysLog);
    }
}
