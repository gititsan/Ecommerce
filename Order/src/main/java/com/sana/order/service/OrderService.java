package com.sana.order.service;

import java.util.List;

import com.sana.order.model.Order;

public interface OrderService {
	public List<Order> getListOrders();

	public void saveAndUpdate(Order  Order);

	public void deleteOrder(int id);

	public Order getOrderById(int id);
}
