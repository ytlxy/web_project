package com.demo.dao;

import com.demo.pojo.emp;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface empmp {
    boolean insert1(emp emp);
    List<emp> select1();
    boolean delete1(emp emp);
    boolean update1(emp emp);
}
