package com.sana.cart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sana.cart.model.Cart;
import com.sana.cart.model.ErrorMessage;
import com.sana.cart.service.CartService;
import com.sana.cart.util.CartUtil;

@RestController
public class CartController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);

	@Autowired
	CartService cartService;

	@GetMapping("/carts")
	public ResponseEntity<Object> getCarts() {
		LOGGER.info("Fetching Cart List");
		ResponseEntity<Object> response = null;
		try {
			response = new ResponseEntity<>(cartService.getListCarts(), HttpStatus.OK);
		} catch (Exception ex) {
			LOGGER.error("Exception While Fetching Cart " + ex);
			ErrorMessage errorMessage = CartUtil.getErrorModel("Exception While Fetching Cart " + ex,
					HttpStatus.INTERNAL_SERVER_ERROR);
			response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@PostMapping("/cart/add")
	public ResponseEntity<Object> addCart(@RequestBody Cart cart) {
		LOGGER.info("Adding Cart");
		ResponseEntity<Object> response = null;
		try {
			cartService.saveAndUpdate(cart);
			response = new ResponseEntity<>("Cart created: " + cart, HttpStatus.OK);
		} catch (Exception ex) {
			LOGGER.error("Exception While Fetching Cart " + ex);
			ErrorMessage errorMessage = CartUtil.getErrorModel("Exception While Creating Cart " + ex,
					HttpStatus.INTERNAL_SERVER_ERROR);
			response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@DeleteMapping("cart/remove/{id}")
	public ResponseEntity<Object> removeCart(@PathVariable int id) {
		LOGGER.info("Deleting Cart with id :" + id);
		ResponseEntity<Object> response = null;
		try {
			cartService.deleteCart(id);
			response = new ResponseEntity<>("Cart with id : " + id + " is deleted! ", HttpStatus.OK);
		} catch (Exception ex) {
			LOGGER.error("Exception While Fetching Cart " + ex);
			ErrorMessage errorMessage = CartUtil.getErrorModel("Exception While Deleting Cart " + ex,
					HttpStatus.INTERNAL_SERVER_ERROR);
			response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;

	}

	@PutMapping("/cart/edit/{id}")
	public ResponseEntity<Object> editCart(@PathVariable int id,@RequestBody Cart cart) {
		// Add check here if doesnt exist
		LOGGER.info("Updating Cart");
		ResponseEntity<Object> response = null;
		try {
			response = new ResponseEntity<>("Cart created: " + cart, HttpStatus.OK);
			cartService.saveAndUpdate(cart);
		} catch (Exception ex) {
			LOGGER.error("Exception While Fetching Cart " + ex);
			ErrorMessage errorMessage = CartUtil.getErrorModel("Exception While Creating Cart " + ex,
					HttpStatus.INTERNAL_SERVER_ERROR);
			response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
}
