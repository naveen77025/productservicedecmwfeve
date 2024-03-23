package com.scaler.productservicedecmwfeve.Repositories;

import com.scaler.productservicedecmwfeve.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepositry extends JpaRepository<Category,Long> {

    Optional<Category> findById(Long id);

    Category save(Category category);

    Category findByName(String name);
}
