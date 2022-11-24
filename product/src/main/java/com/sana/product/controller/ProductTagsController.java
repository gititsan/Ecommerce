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
import com.sana.product.model.Tags;
import com.sana.product.service.ProductService;
import com.sana.product.service.ProductTagsService;
import com.sana.product.util.ProductUtil;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@SwaggerDefinition(tags = { @Tag(name = "Product Tags API", description = "Product Tags Microservice API ") })
@RestController
public class ProductTagsController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductTagsService productTagsService;

	@ApiOperation(value = "Get list of Product's Tags")
	@GetMapping("/productTags")
	public ResponseEntity<Object> getProductTags() {
		LOGGER.info("Fetching Product Tags List");
		ResponseEntity<Object> response = null;
		try {
			response = new ResponseEntity<>(productTagsService.getListProductTags(), HttpStatus.OK);
		} catch (Exception ex) {
			LOGGER.error("Exception While Fetching Product Tags " + ex);
			ErrorMessage errorMessage = ProductUtil.getErrorModel("Exception While Fetching Product Tags " + ex,
					HttpStatus.INTERNAL_SERVER_ERROR);
			response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	

	@ApiOperation(value = "Create A Product Tag")
	@PostMapping("/productTag/add")
	public ResponseEntity<Object> addProduct(@RequestBody Tags tag) {
		LOGGER.info("Adding Product Tag");
		ResponseEntity<Object> response = null;
		try {
			productTagsService.saveAndUpdate(tag);
			response = new ResponseEntity<>("Product Tag created: " + tag, HttpStatus.OK);
		} catch (Exception ex) {
			LOGGER.error("Exception While Fetching Product Tag" + ex);
			ErrorMessage errorMessage = ProductUtil.getErrorModel("Exception While Creating Product Tag" + ex,
					HttpStatus.INTERNAL_SERVER_ERROR);
			response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@ApiOperation(value = "Delete a Product Tag")
	@DeleteMapping("productTag/remove/{id}")
	public ResponseEntity<Object> removeProduct(@PathVariable String id) {
		LOGGER.info("Deleting Product Tag with id :" + id);
		ResponseEntity<Object> response = null;
		try {
			productTagsService.deleteProductTags(id);
			response = new ResponseEntity<>("Product  Tag with id : " + id + " is deleted! ", HttpStatus.OK);
		} catch (Exception ex) {
			LOGGER.error("Exception While Fetching Product Tag" + ex);
			ErrorMessage errorMessage = ProductUtil.getErrorModel("Exception While Deleting Product Tag " + ex,
					HttpStatus.INTERNAL_SERVER_ERROR);
			response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;

	}

	@ApiOperation(value = "Update Product Tags")
	@PutMapping("/productTag/edit/{id}")
	public ResponseEntity<Object> editProduct(@PathVariable String id,@RequestBody Tags tag) {
		// Add check here if doesnt exist
		LOGGER.info("Updating Product Tag");
		ResponseEntity<Object> response = null;
		try {
			response = new ResponseEntity<>("Product Tag created: " + tag, HttpStatus.OK);
			productTagsService.saveAndUpdate(tag);
		} catch (Exception ex) {
			LOGGER.error("Exception While Updating Product Tags " + ex);
			ErrorMessage errorMessage = ProductUtil.getErrorModel("Exception While Updating Product Tags" + ex,
					HttpStatus.INTERNAL_SERVER_ERROR);
			response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

}
