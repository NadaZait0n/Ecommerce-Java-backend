package com.project.database.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.database.Entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>  {

}
