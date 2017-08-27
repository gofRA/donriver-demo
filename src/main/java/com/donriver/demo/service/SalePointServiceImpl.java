package com.donriver.demo.service;

import com.donriver.demo.dao.SalePointRepository;
import com.donriver.demo.model.SalePoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
public class SalePointServiceImpl implements SalePointService{

    @Autowired
    private SalePointRepository repository;

    @Override
    public SalePoint findOne(Integer id) {
        Optional<SalePoint> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new IllegalArgumentException();
        }
        return optional.get();
    }

    @Override
    public List<SalePoint> findAll() {
        return repository.findAll();
    }

    @Override
    public SalePoint update(SalePoint sp) {
        SalePoint old = findOne(sp.getId());
        old.setName(isNull(sp.getName()) ? old.getName() : sp.getName());
        old.setAddress(isNull(sp.getAddress()) ? old.getAddress() : sp.getAddress());
        old.setRetailChain(isNull(sp.getRetailChain()) ? old.getRetailChain() : sp.getRetailChain());
        old.setConsultantCount(isNull(sp.getConsultantCount()) ? old.getConsultantCount() : sp.getConsultantCount());
        return repository.saveAndFlush(old);
    }

    @Override
    public SalePoint create(SalePoint salePoint) {
        return repository.saveAndFlush(salePoint);
    }

    @Override
    public void remove(Integer id) {
        repository.deleteById(id);
    }
}
