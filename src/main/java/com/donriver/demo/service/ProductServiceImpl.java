package com.donriver.demo.service;

import com.donriver.demo.dao.ProductRepository;
import com.donriver.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

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
    public Product update(Product p) {
        Product old = findOne(p.getId());
        old.setName(isNull(p.getName()) ? old.getName() : p.getName());
        old.setCategory(isNull(p.getCategory()) ? old.getCategory() : p.getCategory());
        old.setGuarantee(isNull(p.getGuarantee()) ? old.getGuarantee() : p.getGuarantee());
        old.setSalesCount(isNull(p.getSalesCount()) ? old.getSalesCount() : p.getSalesCount());
        old.setTotalCount(isNull(p.getTotalCount()) ? old.getTotalCount() : p.getTotalCount());
        old.setManufacturer(isNull(p.getManufacturer()) ? old.getManufacturer() : p.getManufacturer());
        return repository.saveAndFlush(old);
    }

    @Override
    public Product create(Product product) {
        return repository.saveAndFlush(product);
    }

    @Override
    public void remove(Integer id) {
        repository.deleteById(id);
    }
}
