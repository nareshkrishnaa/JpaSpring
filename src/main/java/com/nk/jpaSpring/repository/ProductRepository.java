package com.nk.jpaSpring.repository;

import com.nk.jpaSpring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
