package com.donriver.demo.service;


import com.donriver.demo.model.SalePoint;

import java.util.List;

public interface SalePointService {

    SalePoint findOne(Integer id);
    List<SalePoint> findAll();
    SalePoint createOrUpdate(SalePoint salePoint);
    void remove(Integer id);
}
