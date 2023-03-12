package com.project.database.Entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int quantity;
    private int total;
    private String name;
    private String address;
    private String phone;


   @ManyToOne(cascade = CascadeType.MERGE)
   @JoinColumn(name="user_id")
   private User parent;

//    @ManyToMany(fetch = FetchType.LAZY,
//     cascade=CascadeType.ALL)
//     @JoinTable(name = "order_has_product",
//     joinColumns=@JoinColumn(name = "order_id"),
//     inverseJoinColumns = @JoinColumn(name="product_id" ) )
//     private List<Product> products;
}
