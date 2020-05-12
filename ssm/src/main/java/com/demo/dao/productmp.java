package com.demo.dao;

import com.demo.pojo.product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface productmp {
    boolean insert2(product product);
    List<product> select2(product product);
    boolean delete2(product product);
    boolean update2(product product);
}
