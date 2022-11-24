package com.sana.authorities.controller;

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

import com.sana.authorities.model.Authorities;
import com.sana.authorities.model.ErrorMessage;
import com.sana.authorities.service.AuthoritiesService;
import com.sana.authorities.util.AuthoritiesUtil;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@SwaggerDefinition(tags = { @Tag(name = "Authorities API", description = "Authorities Microservice API ") })
@RestController
public class AuthoritiesController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthoritiesController.class);

	@Autowired
	AuthoritiesService authoritiesService;

	@ApiOperation(value = "Get list of Authorities")
	@GetMapping("/authorities")
	public ResponseEntity<Object> getAuthoritiess() {
		LOGGER.info("Fetching Authorities List");
		ResponseEntity<Object> response = null;
		try {
			response = new ResponseEntity<>(authoritiesService.getListAuthoritiess(), HttpStatus.OK);
		} catch (Exception ex) {
			LOGGER.error("Exception While Fetching Authorities " + ex);
			ErrorMessage errorMessage = AuthoritiesUtil.getErrorModel("Exception While Fetching Authorities " + ex,
					HttpStatus.INTERNAL_SERVER_ERROR);
			response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@ApiOperation(value = "Create An Authority")
	@PostMapping("/authorities/add")
	public ResponseEntity<Object> addAuthorities(@RequestBody Authorities authorities) {
		LOGGER.info("Adding Authorities");
		ResponseEntity<Object> response = null;
		try {
			authoritiesService.saveAndUpdate(authorities);
			response = new ResponseEntity<>("Authorities created: " + authorities, HttpStatus.OK);
		} catch (Exception ex) {
			LOGGER.error("Exception While Fetching Authorities " + ex);
			ErrorMessage errorMessage = AuthoritiesUtil.getErrorModel("Exception While Creating Authorities " + ex,
					HttpStatus.INTERNAL_SERVER_ERROR);
			response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@ApiOperation(value = "Delete an Authority")
	@DeleteMapping("authorities/remove/{id}")
	public ResponseEntity<Object> removeAuthorities(@PathVariable int id) {
		LOGGER.info("Deleting Authorities with id :" + id);
		ResponseEntity<Object> response = null;
		try {
			authoritiesService.deleteAuthorities(id);
			response = new ResponseEntity<>("Authorities with id : " + id + " is deleted! ", HttpStatus.OK);
		} catch (Exception ex) {
			LOGGER.error("Exception While Fetching Authorities " + ex);
			ErrorMessage errorMessage = AuthoritiesUtil.getErrorModel("Exception While Deleting Authorities " + ex,
					HttpStatus.INTERNAL_SERVER_ERROR);
			response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;

	}

	@ApiOperation(value = "Update Authority")
	@PutMapping("/authorities/edit/{id}")
	public ResponseEntity<Object> editAuthorities(@PathVariable int id,@RequestBody Authorities authorities) {
		// Add check here if doesnt exist
		LOGGER.info("Updating Authorities");
		ResponseEntity<Object> response = null;
		try {
			response = new ResponseEntity<>("Authorities created: " + authorities, HttpStatus.OK);
			authoritiesService.saveAndUpdate(authorities);
		} catch (Exception ex) {
			LOGGER.error("Exception While Fetching Authorities " + ex);
			ErrorMessage errorMessage = AuthoritiesUtil.getErrorModel("Exception While Creating Authorities " + ex,
					HttpStatus.INTERNAL_SERVER_ERROR);
			response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
}
