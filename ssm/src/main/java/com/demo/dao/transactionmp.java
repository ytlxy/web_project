package com.demo.dao;

import com.demo.pojo.transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface transactionmp {
    boolean insert3(transaction transaction);
    List<transaction> select3();
    boolean delete3(transaction transaction);
    boolean update3(transaction transaction);
    List<transaction> selectuser(transaction Userid);
}
