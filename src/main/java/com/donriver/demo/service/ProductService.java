package com.donriver.demo.service;

import com.donriver.demo.model.Product;

import java.util.List;

public interface ProductService {

    Product findOne(Integer id);
    List<Product> findAll();
    Product update(Product product);
    Product create(Product product);
    void remove(Integer id);
}
