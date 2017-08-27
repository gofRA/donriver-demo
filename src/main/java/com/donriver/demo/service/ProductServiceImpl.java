package com.donriver.demo.service;

import com.donriver.demo.dao.ProductRepository;
import com.donriver.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public Product findOne(Integer id) {
        Optional<Product> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new IllegalArgumentException();
        }
        return optional.get();
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Product createOrUpdate(Product product) {
        return repository.saveAndFlush(product);
    }

    @Override
    public void remove(Integer id) {
        repository.deleteById(id);
    }
}
