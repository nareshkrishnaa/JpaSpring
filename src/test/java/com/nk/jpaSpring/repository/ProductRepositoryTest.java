package com.nk.jpaSpring.repository;

import com.nk.jpaSpring.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

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

    @Test
    void findByIdMethod(){
        int id=1;

        Product product = productRepository.findById(1).get();
    }




    @Test
    void saveAllMethod(){
        //create product2
        Product product2=new Product();
        product2.setName("seepu dabba");
        product2.setPrice(new BigDecimal(32));

        //create product2
        Product product3=new Product();
        product3.setName("paaku dabba");
        product3.setPrice(new BigDecimal(68));

        //saveAll(List) method to save the entities
        productRepository.saveAll(List.of(product2,product3));


    }

    //FindAll() method from crudRepository
    @Test
    void FindAllMethod(){
        List<Product> productList = productRepository.findAll();

        productList.forEach((p)-> System.out.println(p.toString()));
    }

    // deleting an entity using deleteById(primary key value) method of crudRepository interface
    @Test
    void DeleteByIdMethod(){
        int id=3;
        productRepository.deleteById(id);
    }

    //delete() method
    //first save an entity using finById() method--->give the entity object as the argument

    @Test
    void deleteMethod(){
        int id =2;
        Product product=productRepository.findById(id).get();

        productRepository.delete(product);
    }

    //delete all entities in a table
    @Test
    void  deleteAllMethod(){
        productRepository.deleteAll();
    }


    //delete a list of iterable entities using delete all method
    @Test
    void deleteAllInListMethod(){
        Product product1 = productRepository.findById(6).get();
        Product product2 = productRepository.findById(7).get();
        productRepository.deleteAll(List.of(product1,product2));
    }

    //count method od crudRepository interface to count the number of rows of a table

    @Test
    void countMethod(){
        System.out.println(productRepository.count());
    }

    //existsById() method returns a boolean whether or not an entiity exists in table

    @Test
    void existsByIdMethod(){

        System.out.println(productRepository.existsById(3));

    }
}