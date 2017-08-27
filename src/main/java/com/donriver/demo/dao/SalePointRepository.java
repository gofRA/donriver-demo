package com.donriver.demo.dao;

import com.donriver.demo.model.SalePoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalePointRepository extends JpaRepository<SalePoint, Integer> {
}
