package com.sana.supplier.controller;

import java.util.Optional;

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

import com.sana.supplier.model.ErrorMessage;
import com.sana.supplier.model.Supplier;
import com.sana.supplier.service.SupplierService;
import com.sana.supplier.util.SupplierUtil;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@SwaggerDefinition(tags = { @Tag(name = "Supplier API", description = "Supplier Microservice API ") })
@RestController
public class SupplierController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SupplierController.class);

	@Autowired
	SupplierService supplierService;

	@ApiOperation(value = "Get list of Suppliers")
	@GetMapping("/suppliers")
	public ResponseEntity<Object> getSuppliers() {
		LOGGER.info("Fetching Supplier List");
		ResponseEntity<Object> response = null;
		try {
			response = new ResponseEntity<>(supplierService.getListSuppliers(), HttpStatus.OK);
		} catch (Exception ex) {
			LOGGER.error("Exception While Fetching Supplier " + ex);
			ErrorMessage errorMessage = SupplierUtil.getErrorModel("Exception While Fetching Supplier " + ex,
					HttpStatus.INTERNAL_SERVER_ERROR);
			response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	

	@ApiOperation(value = "Create A Supplier")
	@PostMapping("/supplier/add")
	public ResponseEntity<Object> addSupplier(@RequestBody Supplier supplier) {
		LOGGER.info("Adding Supplier");
		ResponseEntity<Object> response = null;
		try {
			supplierService.saveAndUpdate(supplier);
			response = new ResponseEntity<>("Supplier created: " + supplier, HttpStatus.OK);
		} catch (Exception ex) {
			LOGGER.error("Exception While Fetching Supplier " + ex);
			ErrorMessage errorMessage = SupplierUtil.getErrorModel("Exception While Creating Supplier " + ex,
					HttpStatus.INTERNAL_SERVER_ERROR);
			response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@ApiOperation(value = "Delete a Suppier")
	@DeleteMapping("supplier/remove/{id}")
	public ResponseEntity<Object> removeSupplier(@PathVariable String id) {
		LOGGER.info("Deleting Supplier with id :" + id);
		ResponseEntity<Object> response = null;
		try {
			supplierService.deleteSupplier(id);
			response = new ResponseEntity<>("Supplier with id : " + id + " is deleted! ", HttpStatus.OK);
		} catch (Exception ex) {
			LOGGER.error("Exception While Fetching Supplier " + ex);
			ErrorMessage errorMessage = SupplierUtil.getErrorModel("Exception While Deleting Supplier " + ex,
					HttpStatus.INTERNAL_SERVER_ERROR);
			response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;

	}

	@ApiOperation(value = "Update Supplier")
	@PutMapping("/supplier/edit/{id}")
	public ResponseEntity<Object> editSupplier(@PathVariable String id,@RequestBody Supplier supplier) {
		// Add check here if doesnt exist
		LOGGER.info("Updating Supplier");
		ResponseEntity<Object> response = null;
		try {
			response = new ResponseEntity<>("Supplier created: " + supplier, HttpStatus.OK);
			supplierService.saveAndUpdate(supplier);
		} catch (Exception ex) {
			LOGGER.error("Exception While Fetching Supplier " + ex);
			ErrorMessage errorMessage = SupplierUtil.getErrorModel("Exception While Creating Supplier " + ex,
					HttpStatus.INTERNAL_SERVER_ERROR);
			response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

}
