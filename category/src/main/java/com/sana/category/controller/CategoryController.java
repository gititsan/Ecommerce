package com.sana.category.controller;

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

import com.sana.category.model.Category;
import com.sana.category.model.ErrorMessage;
import com.sana.category.service.CategoryService;
import com.sana.category.util.CategoryUtil;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@SwaggerDefinition(tags = { @Tag(name = "Category API", description = "Category Microservice API ") })
@RestController
public class CategoryController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	CategoryService categoryService;

	@ApiOperation(value = "Get list of Categories")
	@GetMapping("/categories")
	public ResponseEntity<Object> getCategorys() {
		LOGGER.info("Fetching Category List");
		ResponseEntity<Object> response = null;
		try {
			response = new ResponseEntity<>(categoryService.getListCategorys(), HttpStatus.OK);
		} catch (Exception ex) {
			LOGGER.error("Exception While Fetching Category " + ex);
			ErrorMessage errorMessage = CategoryUtil.getErrorModel("Exception While Fetching Category " + ex,
					HttpStatus.INTERNAL_SERVER_ERROR);
			response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@ApiOperation(value = "Create A Category")
	@PostMapping("/category/add")
	public ResponseEntity<Object> addCategory(@RequestBody Category category) {
		LOGGER.info("Adding Category");
		ResponseEntity<Object> response = null;
		try {
			categoryService.saveAndUpdate(category);
			response = new ResponseEntity<>("Category created: " + category, HttpStatus.OK);
		} catch (Exception ex) {
			LOGGER.error("Exception While Fetching Category " + ex);
			ErrorMessage errorMessage = CategoryUtil.getErrorModel("Exception While Creating Category " + ex,
					HttpStatus.INTERNAL_SERVER_ERROR);
			response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@ApiOperation(value = "Delete a Category")
	@DeleteMapping("category/remove/{id}")
	public ResponseEntity<Object> removeCategory(@PathVariable String id) {
		LOGGER.info("Deleting Category with id :" + id);
		ResponseEntity<Object> response = null;
		try {
			categoryService.deleteCategory(id);
			response = new ResponseEntity<>("Category with id : " + id + " is deleted! ", HttpStatus.OK);
		} catch (Exception ex) {
			LOGGER.error("Exception While Fetching Category " + ex);
			ErrorMessage errorMessage = CategoryUtil.getErrorModel("Exception While Deleting Category " + ex,
					HttpStatus.INTERNAL_SERVER_ERROR);
			response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;

	}

	@ApiOperation(value = "Update Category")
	@PutMapping("/category/edit/{id}")
	public ResponseEntity<Object> editCategory(@PathVariable String id,@RequestBody Category category) {
		// Add check here if doesnt exist
		LOGGER.info("Updating Category");
		ResponseEntity<Object> response = null;
		try {
			response = new ResponseEntity<>("Category created: " + category, HttpStatus.OK);
			categoryService.saveAndUpdate(category);
		} catch (Exception ex) {
			LOGGER.error("Exception While Fetching Category " + ex);
			ErrorMessage errorMessage = CategoryUtil.getErrorModel("Exception While Creating Category " + ex,
					HttpStatus.INTERNAL_SERVER_ERROR);
			response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
}
