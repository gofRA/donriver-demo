package com.donriver.demo.service;

import com.donriver.demo.model.Product;

import java.util.List;

public interface ProductService {

    Product findOne(Integer id);
    List<Product> findAll();
    Product createOrUpdate(Product product);
    void remove(Integer id);
}
