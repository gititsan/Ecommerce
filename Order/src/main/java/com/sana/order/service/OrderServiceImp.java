package com.sana.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sana.order.model.Order;
import com.sana.order.repository.OrderRepository;
 

@Service
public class OrderServiceImp implements OrderService{
	@Autowired
	private OrderRepository orderRepository;

	public List<Order> getListOrders() {

		return orderRepository.findAll();
	}

	@Override
	public void saveAndUpdate( Order  order) {
		orderRepository.save(order);
		
	}

	@Override
	public void deleteOrder(int id) {
		orderRepository.deleteById(id);
		
	}

	@Override
	public Order getOrderById(int id) {
		return orderRepository.findById(id).get();
				
	}
}
