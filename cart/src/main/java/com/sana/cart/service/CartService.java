package com.sana.cart.service;

import java.util.List;

import com.sana.cart.model.Cart;

public interface CartService {

	public List<Cart> getListCarts();
	public void saveAndUpdate( Cart cart );
	public void deleteCart( int id );
	public Cart getCartById( int id );
}
