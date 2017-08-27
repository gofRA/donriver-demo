package com.donriver.demo.service;

import com.donriver.demo.dao.SalePointRepository;
import com.donriver.demo.model.SalePoint;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static java.util.Optional.empty;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SalePointServiceTests {

    @InjectMocks
    private SalePointServiceImpl salePointService;
    @Mock
    private SalePointRepository salePointRepository;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testFindAll() {
        salePointService.findAll();
        verify(salePointRepository).findAll();
    }

    @Test
    public void testUpdate() {
        SalePoint sp = new SalePoint();
        sp.setId(1);
        when(salePointRepository.findById(anyInt())).thenReturn(Optional.of(sp));
        salePointService.update(sp);
        verify(salePointRepository).findById(anyInt());
        verify(salePointRepository).saveAndFlush(any(SalePoint.class));
    }

    @Test
    public void testCreate() {
        salePointService.create(new SalePoint());
        verify(salePointRepository).saveAndFlush(any(SalePoint.class));
    }

    @Test
    public void testRemove() {
        salePointService.remove(anyInt());
        verify(salePointRepository).deleteById(anyInt());
    }

    @Test
    public void entityNotFound() {
        when(salePointRepository.findById(100)).thenReturn(empty());
        expectedException.expect(IllegalArgumentException.class);
        salePointService.findOne(100);
    }
}
