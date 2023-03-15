package com.project.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.database.Entities.OrderHasProduct;
import com.project.database.Repository.OrderProductRepository;

@RestController
@RequestMapping("/quantity")
public class OrderHasProductController {
    @Autowired
    OrderProductRepository orderProductRepository;


    @PostMapping
    public void insert(@RequestBody OrderHasProduct order ){
        
        orderProductRepository.save(order);
    }




    
}