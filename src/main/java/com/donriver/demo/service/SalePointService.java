package com.donriver.demo.service;


import com.donriver.demo.model.SalePoint;

import java.util.List;

public interface SalePointService {

    SalePoint findOne(Integer id);
    List<SalePoint> findAll();
    SalePoint update(SalePoint salePoint);
    SalePoint create(SalePoint salePoint);
    void remove(Integer id);
}
