package com.sana.product.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@SwaggerDefinition(tags = { @Tag(name = "Product API", description = "Product Microservice API ") })
@RestController
public class ProductController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductService productService;

	@ApiOperation(value = "Get list of Products")
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
	
	
	@ApiOperation(value = "Get list of Products By Id")
	@GetMapping("/products/{id}")
	public ResponseEntity<Object> getProductById(@PathVariable String id) {
		LOGGER.info("Fetching Product By Id");
		ResponseEntity<Object> response = null;
		try {
			response = new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
		} catch (Exception ex) {
			LOGGER.error("Exception While Fetching Product By Id " + ex);
			ErrorMessage errorMessage = ProductUtil.getErrorModel("Exception While Fetching Product By Id " + ex,
					HttpStatus.INTERNAL_SERVER_ERROR);
			response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	

	@ApiOperation(value = "Create A Product")
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

	@ApiOperation(value = "Delete a Product")
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

	@ApiOperation(value = "Update Product")
	@PutMapping("/product/edit/{id}")
	public ResponseEntity<Object> editProduct(@PathVariable String id, @RequestBody Product product) {
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

	@ApiOperation(value = "Dynamic Search By Product Value")
	@GetMapping("product/{description}")
	public ResponseEntity<Object> findProductByDescription(@PathVariable String description) {
		LOGGER.info("Search Product with value :");
		ResponseEntity<Object> response = null;
		try {
			response = new ResponseEntity<>(productService.findProductByDescription(description), HttpStatus.OK);
		} catch (Exception ex) {
			LOGGER.error("Exception While Fetching Product " + ex);
			ErrorMessage errorMessage = ProductUtil.getErrorModel("Exception While searching Product " + ex,
					HttpStatus.INTERNAL_SERVER_ERROR);
			response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;

	}
}
