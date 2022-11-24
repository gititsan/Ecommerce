package com.sana.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sana.order.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
