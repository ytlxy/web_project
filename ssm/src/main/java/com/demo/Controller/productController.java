package com.demo.Controller;

import com.demo.impl.productimpl;
import com.demo.pojo.product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class productController {
    //添加商品
    @RequestMapping("/commodityAdd")
    public ModelAndView commodityAdd(Model model,String name,String Catalog){
        ModelAndView mod=new ModelAndView("commodity");
        product pr=new product();
        pr.setProductName(name);
        pr.setCatalog(Catalog);
        productimpl.insert(pr);
        mod.addObject("merchandise","添加内容:"+pr);
        return mod;
    }
    //查询目录下商品
    @RequestMapping("/commodityInquiry")
    public ModelAndView commodityInquiry(Model model,String Catalog){
        ModelAndView mod=new ModelAndView("commodity");
        product pr=new product();
        pr.setCatalog(Catalog);
        List<product> a=productimpl.select(pr);
        mod.addObject("merchandisest",a);
        return mod;
    }
}
