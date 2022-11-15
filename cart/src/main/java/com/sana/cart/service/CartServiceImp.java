package com.sana.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sana.cart.model.Cart;
import com.sana.cart.repository.CartRepository;

@Service
public class CartServiceImp implements CartService {

	@Autowired
	private CartRepository cartRepository;

	public List<Cart> getListCarts() {

		return cartRepository.findAll();
	}

	@Override
	public void saveAndUpdate(Cart cart) {
		cartRepository.save(cart);
		
	}

	@Override
	public void deleteCart(int id) {
		cartRepository.deleteById(id);
		
	}

	@Override
	public Cart getCartById(int id) {
		return cartRepository.findById(id).get();
				
	}
}
