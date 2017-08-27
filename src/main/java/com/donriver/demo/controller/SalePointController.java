package com.donriver.demo.controller;

import com.donriver.demo.model.SalePoint;
import com.donriver.demo.service.SalePointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/sale_points")
public class SalePointController {

    @Autowired
    private SalePointService salePointService;

    @GetMapping(value = "/")
    @ResponseBody
    public List<SalePoint> getList() {
        return salePointService.findAll();
    }

    @PutMapping(value = "/")
    @ResponseBody
    public SalePoint updateSalePoint(@RequestBody SalePoint sp) {
        return salePointService.update(sp);
    }

    @PostMapping(value = "/")
    @ResponseBody
    public SalePoint createSalePoint(@RequestBody SalePoint sp) {
        return salePointService.create(sp);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(OK)
    public void removeItem(@PathVariable("id") Integer id) {
        salePointService.remove(id);
    }
}
