package com.nk.jpaSpring.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
@Entity
@Table(name = "tbl_products", schema="ecommerce",uniqueConstraints = {@UniqueConstraint(name="id_unique",
columnNames = "id")})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="product name",nullable = false)
    private String name;
    private BigDecimal price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
