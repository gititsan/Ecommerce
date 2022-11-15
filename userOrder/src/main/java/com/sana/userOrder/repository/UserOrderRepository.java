package com.sana.userOrder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sana.userOrder.model.UserOrder;

@Repository
public interface UserOrderRepository extends JpaRepository<UserOrder, Integer>{

}
