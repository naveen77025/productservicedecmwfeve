package com.scaler.productservicedecmwfeve;

import com.scaler.productservicedecmwfeve.Repositories.ProductInterface;
import com.scaler.productservicedecmwfeve.models.Product;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.util.Optional;

@SpringBootTest
class ProductservicedecmwfeveApplicationTests {
    @Autowired
    private ProductInterface productInterface;

    @Test
    @Transactional
    @Commit
    void contextLoads() {
        Optional<Product> product= productInterface.findById(1L);
    }

}
