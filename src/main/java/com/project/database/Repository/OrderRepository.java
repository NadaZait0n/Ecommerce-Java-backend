package com.project.database.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.database.Entities.Order;
import com.project.database.Entities.User;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>  {

  //  List<Order> findByUser(User user);

}
