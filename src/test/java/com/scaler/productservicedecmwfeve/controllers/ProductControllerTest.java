package com.scaler.productservicedecmwfeve.controllers;

import com.scaler.productservicedecmwfeve.models.Product;
import com.scaler.productservicedecmwfeve.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {
    @Autowired
    private ProductController productController;

    @MockBean
    private ProductService productService;

//    @Test
//    void testProductSameAsService(){
//        //arrange
//        List<Product> products = new ArrayList<>();
//        Product p1= new Product();
//        p1.setTitle("Vivo y27");
//        products.add(p1);
//        Product p2= new Product();
//        p2.setTitle("Vivo y28");
//        products.add(p2);
//        Product p3= new Product();
//        p3.setTitle("Vivo y28 5G");
//        products.add(p3);
//        when(
//                productService.getAllProducts()
//        ).thenReturn(products);
//
//        List<Product> prductsToPass= new ArrayList<>();
//        for (int i=0;i<products.size();i++){
//            Product p11= new Product();
//            p11.setTitle(products.get(i).getTitle());
//            prductsToPass.add(p11);
//        }
        //act
//        List<Product> response = productController.getAllProducts();
//
//        //assert
//        assertEquals(prductsToPass.size(),response.size());
//
//        for (int i=0; i<products.size();i++){
//            assertEquals(prductsToPass.get(i).getTitle(),response.get(i).getTitle());
//
//        }
       // for (Product product)

   // }

}