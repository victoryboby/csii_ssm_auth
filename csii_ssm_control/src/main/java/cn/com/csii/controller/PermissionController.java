package cn.com.csii.controller;

import cn.com.csii.domain.Permission;
import cn.com.csii.domain.Role;
import cn.com.csii.service.PerService;
import cn.com.csii.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PerService perService;
    @RequestMapping("/findAll")
    public ModelAndView findAll() throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Permission> permissions  = perService.findAll();
        mv.addObject("perList",permissions);
        mv.setViewName("per-list");
        return mv;
    }

    @RequestMapping("/save")
    public String saveUser(Permission permission) throws Exception{
        perService.savaPer(permission);
        return "redirect: findAll.do";
    }
}
