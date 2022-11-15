package com.sana.userOrder.service;

import java.util.List;

import com.sana.userOrder.model.UserOrder;

public interface UserOrderService {
	public List<UserOrder> getListUserOrders();

	public void saveAndUpdate(UserOrder userOrder);

	public void deleteUserOrder(int id);

	public UserOrder getUserOrderById(int id);
}
