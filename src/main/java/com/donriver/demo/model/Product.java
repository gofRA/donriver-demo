package com.donriver.demo.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "manufacturer_country")
    private String manufacturer;

    @Column(name = "guarantee")
    private Integer guarantee;

    @Column(name = "total_count")
    private Integer totalCount;

    @Column(name = "sales_count")
    private Integer salesCount;
}
