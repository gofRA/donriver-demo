package com.donriver.demo.controller;

import com.donriver.demo.model.Product;
import com.donriver.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/")
    @ResponseBody
    public List<Product> getList() {
        return productService.findAll();
    }

    @PutMapping(value = "/")
    @ResponseBody
    public Product updateProduct(@RequestBody Product p) {
        return productService.update(p);
    }

    @PostMapping(value = "/")
    @ResponseBody
    public Product createProduct(@RequestBody Product p) {
        return productService.create(p);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(OK)
    public void removeProduct(@PathVariable("id") Integer id) {
        productService.remove(id);
    }

}
