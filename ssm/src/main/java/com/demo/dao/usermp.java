package com.demo.dao;

import com.demo.pojo.user;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface usermp {
    boolean insert4(user user);
    List<user> select4();
    boolean delete4(user user);
    boolean update4(user user);
}
