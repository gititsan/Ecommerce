package com.sana.order.controller;

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

import com.sana.order.model.ErrorMessage;
import com.sana.order.model.Order;
import com.sana.order.service.OrderService;
import com.sana.order.util.OrderUtil;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@SwaggerDefinition(tags = { @Tag(name = "User Order API", description = "User Order Microservice API ") })
@RestController
public class OrderController {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	OrderService orderService;

	@ApiOperation(value = "Get list of User Orders")
	@GetMapping("/orders")
	public ResponseEntity<Object> getOrders() {
		LOGGER.info("Fetching Order List");
		ResponseEntity<Object> response = null;
		try {
			response = new ResponseEntity<>(orderService.getListOrders(), HttpStatus.OK);
		} catch (Exception ex) {
			LOGGER.error("Exception While Fetching Order " + ex);
			ErrorMessage errorMessage = OrderUtil.getErrorModel("Exception While Fetching Order " + ex,
					HttpStatus.INTERNAL_SERVER_ERROR);
			response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@ApiOperation(value = "Create A User Order")
	@PostMapping("/order/add")
	public ResponseEntity<Object> addOrder(@RequestBody Order Order) {
		LOGGER.info("Adding Order");
		
		
		ResponseEntity<Object> response = null;
		try {
			orderService.saveAndUpdate(Order);
			response = new ResponseEntity<>("Order created: " + Order, HttpStatus.OK);
		} catch (Exception ex) {
			LOGGER.error("Exception While Fetching Order " + ex);
			ErrorMessage errorMessage = OrderUtil.getErrorModel("Exception While Creating Order " + ex,
					HttpStatus.INTERNAL_SERVER_ERROR);
			response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@ApiOperation(value = "Delete a User Order")
	@DeleteMapping("order/remove/{id}")
	public ResponseEntity<Object> removeOrder(@PathVariable int id) {
		LOGGER.info("Deleting Order with id :" + id);
		ResponseEntity<Object> response = null;
		try {
			orderService.deleteOrder(id);
			response = new ResponseEntity<>("Order with id : " + id + " is deleted! ", HttpStatus.OK);
		} catch (Exception ex) {
			LOGGER.error("Exception While Fetching Order " + ex);
			ErrorMessage errorMessage = OrderUtil.getErrorModel("Exception While Deleting Order " + ex,
					HttpStatus.INTERNAL_SERVER_ERROR);
			response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;

	}

	@ApiOperation(value = "Update User Order")
	@PutMapping("/order/edit/{id}")
	public ResponseEntity<Object> editOrder(@PathVariable int id,@RequestBody Order Order) {
		// Add check here if doesnt exist
		LOGGER.info("Updating Order");
		ResponseEntity<Object> response = null;
		try {
			response = new ResponseEntity<>("Order created: " + Order, HttpStatus.OK);
			orderService.saveAndUpdate(Order);
		} catch (Exception ex) {
			LOGGER.error("Exception While Fetching Order " + ex);
			ErrorMessage errorMessage = OrderUtil.getErrorModel("Exception While Creating Order " + ex,
					HttpStatus.INTERNAL_SERVER_ERROR);
			response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
}
