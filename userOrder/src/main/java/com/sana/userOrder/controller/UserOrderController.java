package com.sana.userOrder.controller;

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

import com.sana.userOrder.model.ErrorMessage;
import com.sana.userOrder.model.UserOrder;
import com.sana.userOrder.service.UserOrderService;
import com.sana.userOrder.util.UserOrderUtil;

@RestController
public class UserOrderController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserOrderController.class);

	@Autowired
	UserOrderService userOrderService;

	@GetMapping("/userOrders")
	public ResponseEntity<Object> getUserOrders() {
		LOGGER.info("Fetching UserOrder List");
		ResponseEntity<Object> response = null;
		try {
			response = new ResponseEntity<>(userOrderService.getListUserOrders(), HttpStatus.OK);
		} catch (Exception ex) {
			LOGGER.error("Exception While Fetching UserOrder " + ex);
			ErrorMessage errorMessage = UserOrderUtil.getErrorModel("Exception While Fetching UserOrder " + ex,
					HttpStatus.INTERNAL_SERVER_ERROR);
			response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@PostMapping("/userOrder/add")
	public ResponseEntity<Object> addUserOrder(@RequestBody UserOrder userOrder) {
		LOGGER.info("Adding UserOrder");
		
		
		ResponseEntity<Object> response = null;
		try {
			userOrderService.saveAndUpdate(userOrder);
			response = new ResponseEntity<>("UserOrder created: " + userOrder, HttpStatus.OK);
		} catch (Exception ex) {
			LOGGER.error("Exception While Fetching UserOrder " + ex);
			ErrorMessage errorMessage = UserOrderUtil.getErrorModel("Exception While Creating UserOrder " + ex,
					HttpStatus.INTERNAL_SERVER_ERROR);
			response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@DeleteMapping("userOrder/remove/{id}")
	public ResponseEntity<Object> removeUserOrder(@PathVariable int id) {
		LOGGER.info("Deleting UserOrder with id :" + id);
		ResponseEntity<Object> response = null;
		try {
			userOrderService.deleteUserOrder(id);
			response = new ResponseEntity<>("UserOrder with id : " + id + " is deleted! ", HttpStatus.OK);
		} catch (Exception ex) {
			LOGGER.error("Exception While Fetching UserOrder " + ex);
			ErrorMessage errorMessage = UserOrderUtil.getErrorModel("Exception While Deleting UserOrder " + ex,
					HttpStatus.INTERNAL_SERVER_ERROR);
			response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;

	}

	@PutMapping("/userOrder/edit/{id}")
	public ResponseEntity<Object> editUserOrder(@PathVariable int id,@RequestBody UserOrder userOrder) {
		// Add check here if doesnt exist
		LOGGER.info("Updating UserOrder");
		ResponseEntity<Object> response = null;
		try {
			response = new ResponseEntity<>("UserOrder created: " + userOrder, HttpStatus.OK);
			userOrderService.saveAndUpdate(userOrder);
		} catch (Exception ex) {
			LOGGER.error("Exception While Fetching UserOrder " + ex);
			ErrorMessage errorMessage = UserOrderUtil.getErrorModel("Exception While Creating UserOrder " + ex,
					HttpStatus.INTERNAL_SERVER_ERROR);
			response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
}
