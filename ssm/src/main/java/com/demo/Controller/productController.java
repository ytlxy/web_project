package com.demo.Controller;

import com.demo.impl.productimpl;
import com.demo.pojo.product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class productController {
    //查询商品  //暂时无法跳转
    @RequestMapping("commodity")
    public ModelAndView commodity(Model model,product pReduct){
        ModelAndView mod=new ModelAndView("commodity");
        mod.addObject("merchandise",productimpl.select(pReduct));
        return mod;
    }
    //添加商品
}
