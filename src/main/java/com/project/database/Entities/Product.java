package com.project.database.Entities;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "product")


public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private String description;
    private int category_id;
    private String image_url;
//@Lob
//private byte[] image;
//    @OneToMany(mappedBy="product_id")
//    private Set<Image> ProductImage;
}