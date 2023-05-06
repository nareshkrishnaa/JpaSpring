package com.nk.jpaSpring.repository;

import com.nk.jpaSpring.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
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

    @Test
    void GreaterThanQueryMethod(){
       List<Product> list = productRepository.findByPriceGreaterThan(new BigDecimal(25));
        list.forEach((n)-> System.out.println(n.toString()));
    }
    @Test
    void LesserThanQueryMethod(){
        List<Product> list = productRepository.findByPriceLessThan(new BigDecimal(25));
        list.forEach((n)-> System.out.println(n.toString()));
    }
    @Test
    void ContainingQueryMethod(){
        List<Product> list = productRepository.findByNameContaining("aku");
        if(list.isEmpty()){
            System.out.println("List Empty");
        }
        list.forEach((n)-> System.out.println(n.toString()));
    }

    @Test
    void BetweenQueryMethod(){
        List<Product> list = productRepository.findByPriceBetween(new BigDecimal(10),new BigDecimal(25));
        if(list.isEmpty()){
            System.out.println("List Empty");
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        list.forEach((n)-> System.out.println(n.toString()));
        System.out.println("----------------------------------------------------------------------------------------------------------------");
    }

    @Test
    void FindInQueryMethod(){
       List<String> names = new ArrayList<>();
        names.add("paaku dabba");
        names.add("soapu dabba");
        names.add("seepu dabba");
        List<Product> list = productRepository.findByNameIn(names);
        if(list.isEmpty()){
            System.out.println("List Empty");
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        list.forEach((n)-> System.out.println(n.toString()));
        System.out.println("----------------------------------------------------------------------------------------------------------------");
    }




}
