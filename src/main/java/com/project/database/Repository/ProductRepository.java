package com.project.database.Repository;

import com.project.database.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public  interface ProductRepository extends JpaRepository<Product, Integer> {

}
