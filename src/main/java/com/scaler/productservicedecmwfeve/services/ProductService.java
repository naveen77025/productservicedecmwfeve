package com.scaler.productservicedecmwfeve.services;

import com.scaler.productservicedecmwfeve.dtos.FakeStoreProductDto;
import com.scaler.productservicedecmwfeve.models.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(Long id);

    List<Product> getAllProducts ();

    List<String> getAllCategories();

    List<Product> getAllProductsByCategory(String category);

    Product addNewProduct(Product product);

    Product deleteProduct(Long id);

    Product updateproduct (Long id, Product product);
}
