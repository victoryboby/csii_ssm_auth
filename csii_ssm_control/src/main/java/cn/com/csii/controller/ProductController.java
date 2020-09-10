package cn.com.csii.controller;

import cn.com.csii.domain.Order;
import cn.com.csii.domain.Product;
import cn.com.csii.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping("/findAll.do")
    public ModelAndView findall() throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Product> pts = productService.findAll();
        mv.addObject("productList",pts);
        mv.setViewName("product-list");
        return mv;
    }
    @RequestMapping("/save.do")
    public String save(Product product) throws Exception{
        productService.save(product);
        return "redirect:findall.do";
    }



}
