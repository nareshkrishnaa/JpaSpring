package com.nk.jpaSpring.repository;

import com.nk.jpaSpring.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@SpringBootTest
public class QueryMethodTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameQueryMethod(){

        List<Product> productList = productRepository.findByName("paaku dabba");

        for(Product p :productList){
            System.out.println(p.toString());
        }
    }

    @Test
    void MultipleParameterQueryMethods(){
        List<Product> list1 = productRepository.findByNameAndPrice("paaku dabba",new BigDecimal(42.00));
        List<Product> list2 = productRepository.findByNameOrPrice("paaku dabba",new BigDecimal(42.00));

        list1.forEach((n)-> System.out.println(n.toString()));
        System.out.println("----------------------------------------");
        list2.forEach((n)-> System.out.println(n.toString()));
    }

    @Test
    void DistinctQueryMethod(){
        Product p = productRepository.findDistinctByName("seepu dabba");
        System.out.println(p.toString());

        p=productRepository.findDistinctByNameAndPrice("paaku dabba",new BigDecimal(68.00));
        System.out.println(p.toString());
    }


}
