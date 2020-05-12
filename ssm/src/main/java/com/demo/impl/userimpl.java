package com.demo.impl;

import com.demo.dao.usermp;
import com.demo.pojo.user;
import com.demo.util.mybatisutli;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("userImpl")
public class userimpl {
    public static List<user> select(){
        List<user> a= mybatisutli.getSqlSession().getMapper(usermp.class).select4();
        mybatisutli.getSqlSession().commit();
        mybatisutli.close();
        return a;
    }
    public static void insert(user User){
        mybatisutli.getSqlSession().getMapper(usermp.class).insert4(User);
        mybatisutli.getSqlSession().commit();
        mybatisutli.close();
        System.out.println(User);
    }
}
