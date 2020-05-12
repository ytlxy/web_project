package com.demo.impl;

import com.demo.dao.transactionmp;
import com.demo.pojo.transaction;
import com.demo.util.mybatisutli;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("transactionImpl")
public class transactionimpl {
    public static List<transaction> select(){
        List<transaction> a= mybatisutli.getSqlSession().getMapper(transactionmp.class).select3();
        mybatisutli.close();
        return a;
    }
    public static void insert(transaction Transaction){
        mybatisutli.getSqlSession().getMapper(transactionmp.class).insert3(Transaction);
        mybatisutli.getSqlSession().commit();
        mybatisutli.close();
        System.out.println(Transaction);
    }
}
