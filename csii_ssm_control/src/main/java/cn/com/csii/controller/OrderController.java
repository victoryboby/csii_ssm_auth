package cn.com.csii.controller;

import cn.com.csii.domain.Order;
import cn.com.csii.service.OrderService;
import cn.com.csii.service.ProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/findAll.do")
    public ModelAndView findOrder(@RequestParam(name = "page",required = true) Integer pageNum,@RequestParam(name = "pageSize",required = true) Integer pageSize) throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Order> ods = orderService.findAll(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(ods);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-list");

        return mv;
    }
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) String id) throws Exception{
        ModelAndView mv = new ModelAndView();
        Order ods = orderService.findById(id);
        mv.addObject("orders",ods);
        mv.setViewName("orders-show");
        return mv;
    }
}
