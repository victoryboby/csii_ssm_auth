package cn.com.csii.controller;

import cn.com.csii.domain.Role;
import cn.com.csii.domain.UserInfo;
import cn.com.csii.service.RoleService;
import cn.com.csii.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAll")
    public ModelAndView findAll() throws Exception{
        ModelAndView mv = new ModelAndView();
        List<UserInfo> users  = userService.findAll();
        mv.addObject("userList",users);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/save")
    public String saveUser(UserInfo userInfo) throws Exception{
        userService.saveUser(userInfo);
        return "redirect: findAll.do";
    }

    @RequestMapping("/findById")
    public ModelAndView findById(String id) throws Exception{
        ModelAndView mv = new ModelAndView();
        UserInfo user = userService.findById(id);
        mv.addObject("user",user);
        mv.setViewName("user-show");
        return mv;
    }

    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(String id) throws Exception{
        ModelAndView mv = new ModelAndView();
        UserInfo user = userService.findById(id);
        List<Role> roles = roleService.findUserByIdAndAllRole(id);
        mv.addObject("user",user);
        mv.addObject("roleList",roles);
        mv.setViewName("user-role-add");
        return mv;
    }


    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(String userId, String ids[]) throws Exception{
        for (int i = 0; i < ids.length; i++) {
            userService.addRoleToUser(userId,ids[i]);
        }

        return "redirect: findAll.do";
    }
}
