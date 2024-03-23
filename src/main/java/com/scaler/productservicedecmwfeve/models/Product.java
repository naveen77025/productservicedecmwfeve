package com.scaler.productservicedecmwfeve.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String title;
    private Double price;
    @ManyToOne
    private Category category;
    private String description;
    private String imageUrl;
}
