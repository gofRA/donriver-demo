package com.donriver.demo.service;

import com.donriver.demo.dao.ProductRepository;
import com.donriver.demo.model.Product;
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
public class ProductServiceTests {

    @InjectMocks
    private ProductServiceImpl productService;
    @Mock
    private ProductRepository productRepository;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testFindAll() {
        productService.findAll();
        verify(productRepository).findAll();
    }

    @Test
    public void testUpdate() {
        Product p = new Product();
        p.setId(1);
        when(productRepository.findById(anyInt())).thenReturn(Optional.of(p));
        productService.update(p);
        verify(productRepository).findById(anyInt());
        verify(productRepository).saveAndFlush(any(Product.class));
    }

    @Test
    public void testCreate() {
        productService.create(new Product());
        verify(productRepository).saveAndFlush(any(Product.class));
    }

    @Test
    public void testRemove() {
        productService.remove(anyInt());
        verify(productRepository).deleteById(anyInt());
    }

    @Test
    public void entityNotFound() {
        when(productRepository.findById(100)).thenReturn(empty());
        expectedException.expect(IllegalArgumentException.class);
        productService.findOne(100);
    }
}
