package com.demo.impl;

import com.demo.dao.empmp;
import com.demo.pojo.emp;
import com.demo.util.mybatisutli;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("empImpl")
public class empimpl {
    public static List<emp> select(){
        List<emp> a= mybatisutli.getSqlSession().getMapper(empmp.class).select1();
        mybatisutli.getSqlSession().commit();
        mybatisutli.close();
        return a;
    }
    public static void insert(emp Emp){
        mybatisutli.getSqlSession().getMapper(empmp.class).insert1(Emp);
        mybatisutli.getSqlSession().commit();
        mybatisutli.close();
        System.out.println(Emp);
    }
}
