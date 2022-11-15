package com.sana.userOrder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sana.userOrder.model.UserOrder;
import com.sana.userOrder.repository.UserOrderRepository;

@Service
public class UserOrderServiceImp implements UserOrderService{
	@Autowired
	private UserOrderRepository userOrderRepository;

	public List<UserOrder> getListUserOrders() {

		return userOrderRepository.findAll();
	}

	@Override
	public void saveAndUpdate(UserOrder userOrder) {
		userOrderRepository.save(userOrder);
		
	}

	@Override
	public void deleteUserOrder(int id) {
		userOrderRepository.deleteById(id);
		
	}

	@Override
	public UserOrder getUserOrderById(int id) {
		return userOrderRepository.findById(id).get();
				
	}
}
