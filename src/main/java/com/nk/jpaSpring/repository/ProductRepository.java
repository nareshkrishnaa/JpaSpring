package com.nk.jpaSpring.repository;

import com.nk.jpaSpring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

public List<Product> findByName(String name);
public List<Product> findByNameOrPrice(String name, BigDecimal price);
public List<Product> findByNameAndPrice(String name, BigDecimal price);

public Product findDistinctByName(String name);
public Product findDistinctByNameAndPrice(String name,BigDecimal price);
}
