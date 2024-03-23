package com.scaler.productservicedecmwfeve.services;

import com.scaler.productservicedecmwfeve.Repositories.CategoryRepositry;
import com.scaler.productservicedecmwfeve.Repositories.ProductInterface;
import com.scaler.productservicedecmwfeve.dtos.FakeStoreProductDto;
import com.scaler.productservicedecmwfeve.models.Category;
import com.scaler.productservicedecmwfeve.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class LProductservice implements ProductService{
    private ProductInterface productInterface;

    private CategoryRepositry categoryRepositry;

    @Autowired
    public LProductservice(ProductInterface productInterface, CategoryRepositry categoryRepositry) {
        this.productInterface = productInterface;
        this.categoryRepositry= categoryRepositry;
    }

    @Override
    public Product getSingleProduct(Long id) {
        Optional<Product> optionalProduct= productInterface.findById(id);
        if(optionalProduct.isEmpty()){

        }
        Product product= optionalProduct.get();
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return productInterface.findAll();
    }

    @Override
    public List<String> getAllCategories() {
        return null;
    }

    @Override
    public List<Product> getAllProductsByCategory(String category) {
        return null;
    }

    @Override
    public Product addNewProduct(Product product) {
        Category category= categoryRepositry.findByName(product.getCategory().getName());
        if(category==null){
            Category savedCategory = categoryRepositry.save(product.getCategory());
            product.setCategory(savedCategory);
        }
        else{
            product.setCategory(category);
        }
        return productInterface.save(product);
    }

    @Override
    public Product deleteProduct(Long id) {
        Optional<Product> optionalProduct = productInterface.findById(id);
        if(optionalProduct.isPresent()){
            productInterface.deleteById(id);
        }
        return optionalProduct.get();
    }

    @Override
    public Product updateproduct(Long id, Product product) {
        Optional<Product> product1= productInterface.findById(id);
        if(product1.isEmpty()){
            throw new RuntimeException("no product with id:"+id);
        }
        Product product2= product1.get();
        if (product.getTitle()!=null){
            product2.setTitle(product.getTitle());
        }
        if (product.getDescription()!=null){
            product2.setDescription(product.getDescription());
        }
        if (product.getPrice()!=null){
            product2.setPrice(product.getPrice());
        }
        if (product.getImageUrl()!=null){
            product2.setImageUrl(product.getImageUrl());
        }
        if (product.getTitle()!=null){
            product2.setTitle(product.getTitle());
        }
        if(product.getCategory()!=null){
            Category category= categoryRepositry.findByName(product.getCategory().getName());
            if(category==null){
                Category savedCategory = categoryRepositry.save(product.getCategory());
                product2.setCategory(savedCategory);
            }
            else{
                product2.setCategory(category);
            }
        }
        return productInterface.save(product2);
    }
}
