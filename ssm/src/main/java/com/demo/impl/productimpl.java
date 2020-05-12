package com.demo.impl;

import com.demo.dao.productmp;
import com.demo.pojo.product;
import com.demo.util.mybatisutli;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("productImpl")
public class productimpl {
    public static List<product> select(product product){
        List<product> a= mybatisutli.getSqlSession().getMapper(productmp.class).select2(product);
        mybatisutli.getSqlSession().commit();
        mybatisutli.close();
        return a;
    }
    public static void insert(product Product){
        mybatisutli.getSqlSession().getMapper(productmp.class).insert2(Product);
        mybatisutli.getSqlSession().commit();
        mybatisutli.close();
        System.out.println(Product);
    }
}
