package com.nk.jpaSpring.repository;

import com.nk.jpaSpring.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod()
    {
         //create product
        Product product=new Product();
        product.setName("soapu dabba");
        product.setPrice(new BigDecimal(99.99));
        //save in db
        Product savedProject=productRepository.save(product);
        //sout
        System.out.println(savedProject.toString());
    }

    @Test
    void updateSaveMethod(){
        int id=1;

        Product product=productRepository.findById(id).get();
        //update info
        product.setPrice(new BigDecimal(95));

        //save
        productRepository.save(product);
    }
}