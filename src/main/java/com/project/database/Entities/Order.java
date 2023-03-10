package com.project.database.Entities;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "order")
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
}
