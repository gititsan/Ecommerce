package com.sana.product.controller;

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

import com.sana.product.model.ErrorMessage;
import com.sana.product.model.Product;
import com.sana.product.service.ProductService;
import com.sana.product.util.ProductUtil;

@RestController
public class ProductController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductService productService;

	@GetMapping("/products")
	public ResponseEntity<Object> getProducts() {
		LOGGER.info("Fetching Product List");
		ResponseEntity<Object> response = null;
		try {
			response = new ResponseEntity<>(productService.getListProducts(), HttpStatus.OK);
		} catch (Exception ex) {
			LOGGER.error("Exception While Fetching Product " + ex);
			ErrorMessage errorMessage = ProductUtil.getErrorModel("Exception While Fetching Product " + ex,
					HttpStatus.INTERNAL_SERVER_ERROR);
			response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@PostMapping("/product/add")
	public ResponseEntity<Object> addProduct(@RequestBody Product product) {
		LOGGER.info("Adding Product");
		ResponseEntity<Object> response = null;
		try {
			productService.saveAndUpdate(product);
			response = new ResponseEntity<>("Product created: " + product, HttpStatus.OK);
		} catch (Exception ex) {
			LOGGER.error("Exception While Fetching Product " + ex);
			ErrorMessage errorMessage = ProductUtil.getErrorModel("Exception While Creating Product " + ex,
					HttpStatus.INTERNAL_SERVER_ERROR);
			response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@DeleteMapping("product/remove/{id}")
	public ResponseEntity<Object> removeProduct(@PathVariable String id) {
		LOGGER.info("Deleting Product with id :" + id);
		ResponseEntity<Object> response = null;
		try {
			productService.deleteProduct(id);
			response = new ResponseEntity<>("Product with id : " + id + " is deleted! ", HttpStatus.OK);
		} catch (Exception ex) {
			LOGGER.error("Exception While Fetching Product " + ex);
			ErrorMessage errorMessage = ProductUtil.getErrorModel("Exception While Deleting Product " + ex,
					HttpStatus.INTERNAL_SERVER_ERROR);
			response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;

	}

	@PutMapping("/product/edit/{id}")
	public ResponseEntity<Object> editProduct(@PathVariable String id,@RequestBody Product product) {
		// Add check here if doesnt exist
		LOGGER.info("Updating Product");
		ResponseEntity<Object> response = null;
		try {
			response = new ResponseEntity<>("Product created: " + product, HttpStatus.OK);
			productService.saveAndUpdate(product);
		} catch (Exception ex) {
			LOGGER.error("Exception While Fetching Product " + ex);
			ErrorMessage errorMessage = ProductUtil.getErrorModel("Exception While Creating Product " + ex,
					HttpStatus.INTERNAL_SERVER_ERROR);
			response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
}
