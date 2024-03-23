package com.scaler.productservicedecmwfeve.services;

import com.scaler.productservicedecmwfeve.dtos.FakeStoreProductDto;
import com.scaler.productservicedecmwfeve.models.Category;
import com.scaler.productservicedecmwfeve.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {
    private RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private Product convertFakeStoreProductToProduct(FakeStoreProductDto fakeStoreProduct) {
        Product product = new Product();
        product.setTitle(fakeStoreProduct.getTitle());
        product.setId(fakeStoreProduct.getId());
        product.setPrice(fakeStoreProduct.getPrice());
        product.setDescription(fakeStoreProduct.getDescription());
        product.setImageUrl(fakeStoreProduct.getImage());
        product.setCategory(new Category());
        product.getCategory().setName(fakeStoreProduct.getCategory());

        return product;
    }

    @Override
    public Product getSingleProduct(Long id) {
        FakeStoreProductDto productDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + id,
                FakeStoreProductDto.class
        );

        return convertFakeStoreProductToProduct(productDto);
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductDtos= restTemplate.getForObject("https://fakestoreapi.com/products",FakeStoreProductDto[].class);
        List<Product> fakeStoreProductDtos1= new ArrayList<>();
        if(fakeStoreProductDtos==null) return fakeStoreProductDtos1;
        for (FakeStoreProductDto fakeStoreProductDto:fakeStoreProductDtos){
            fakeStoreProductDtos1.add(convertFakeStoreProductToProduct(fakeStoreProductDto));
        }
        return fakeStoreProductDtos1;
    }

    @Override
    public List<String> getAllCategories() {
        String[] response= restTemplate.getForObject("https://fakestoreapi.com/products/categories",String[].class);
        List<String> categories= new ArrayList<>();
        assert response != null;
        Collections.addAll(categories, response);
        return categories;
    }

    @Override
    public List<Product> getAllProductsByCategory(String category) {
        FakeStoreProductDto[] fakeStoreProductDtos= restTemplate.getForObject("https://fakestoreapi.com/products/category/"+category,FakeStoreProductDto[].class);
        List<Product> fakeStoreProductDtos1= new ArrayList<>();
        if(fakeStoreProductDtos==null) return fakeStoreProductDtos1;
        for (FakeStoreProductDto fakeStoreProductDto:fakeStoreProductDtos){
            fakeStoreProductDtos1.add(convertFakeStoreProductToProduct(fakeStoreProductDto));
        }
        return fakeStoreProductDtos1;
    }

    @Override
    public Product addNewProduct(Product product) {
//        FakeStoreProductDto fakeStoreProductDto= restTemplate.postForObject("https://fakestoreapi.com/products",product,FakeStoreProductDto.class);
//        return convertFakeStoreProductToProduct(fakeStoreProductDto);
        return null;
    }

    @Override
    public Product deleteProduct(Long id) {
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor =
                new HttpMessageConverterExtractor<>(FakeStoreProductDto.class , restTemplate.getMessageConverters());
        FakeStoreProductDto fakeStoreProductDto = restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.DELETE, null, responseExtractor);
        return convertFakeStoreProductToProduct(fakeStoreProductDto);
    }

    @Override
    public Product updateproduct(Long id, Product product) {
        return null;
    }
}
