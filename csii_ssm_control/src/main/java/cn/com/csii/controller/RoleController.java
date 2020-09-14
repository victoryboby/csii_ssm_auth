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
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private PerService perService;

    @RequestMapping("/findAll")
    public ModelAndView findAll() throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Role> roles  = roleService.findAll();
        mv.addObject("roleList",roles);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("/save")
    public String saveUser(Role role) throws Exception{
        roleService.saveRole(role);
        return "redirect: findAll.do";
    }

    @RequestMapping("/findPerByIdAndAllPre")
    public ModelAndView findPerByIdAndAllPre(String id) throws Exception{
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findById(id);

        List<Permission> permissions = perService.findPerByIdAndAllPre(id);
        mv.addObject("role",role);
        mv.addObject("perList",permissions);
        mv.setViewName("role-per-add");
        return mv;
    }


    @RequestMapping("/addPreToRole")
    public String addPreToRole(String roleId, String ids[]) throws Exception{
        for (int i = 0; i < ids.length; i++) {
            roleService.addPreToRole(roleId,ids[i]);
        }

        return "redirect: findAll.do";
    }
}
