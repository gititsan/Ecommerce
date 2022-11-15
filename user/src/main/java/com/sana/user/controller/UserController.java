package com.sana.user.controller;

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

import com.sana.user.model.ErrorMessage;
import com.sana.user.model.User;
import com.sana.user.service.UserService;
import com.sana.user.util.UserUtil;

@RestController
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@GetMapping("/users")
	public ResponseEntity<Object> getUsers() {
		LOGGER.info("Fetching User List");
		ResponseEntity<Object> response = null;
		try {
			response = new ResponseEntity<>(userService.getListUsers(), HttpStatus.OK);
		} catch (Exception ex) {
			LOGGER.error("Exception While Fetching User " + ex);
			ErrorMessage errorMessage = UserUtil.getErrorModel("Exception While Fetching User " + ex,
					HttpStatus.INTERNAL_SERVER_ERROR);
			response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@PostMapping("/user/add")
	public ResponseEntity<Object> addUser(@RequestBody User user) {
		LOGGER.info("Adding User");
		ResponseEntity<Object> response = null;
		try {
			userService.saveAndUpdate(user);
			response = new ResponseEntity<>("User created: " + user, HttpStatus.OK);
		} catch (Exception ex) {
			LOGGER.error("Exception While Fetching User " + ex);
			ErrorMessage errorMessage = UserUtil.getErrorModel("Exception While Creating User " + ex,
					HttpStatus.INTERNAL_SERVER_ERROR);
			response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@DeleteMapping("user/remove/{id}")
	public ResponseEntity<Object> removeUser(@PathVariable String id) {
		LOGGER.info("Deleting User with id :" + id);
		ResponseEntity<Object> response = null;
		try {
			userService.deleteUser(id);
			response = new ResponseEntity<>("User with id : " + id + " is deleted! ", HttpStatus.OK);
		} catch (Exception ex) {
			LOGGER.error("Exception While Fetching User " + ex);
			ErrorMessage errorMessage = UserUtil.getErrorModel("Exception While Deleting User " + ex,
					HttpStatus.INTERNAL_SERVER_ERROR);
			response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;

	}

	@PutMapping("/user/edit/{id}")
	public ResponseEntity<Object> editUser(@PathVariable String id,@RequestBody User user) {
		// Add check here if doesnt exist
		LOGGER.info("Updating User");
		ResponseEntity<Object> response = null;
		try {
			response = new ResponseEntity<>("User created: " + user, HttpStatus.OK);
			userService.saveAndUpdate(user);
		} catch (Exception ex) {
			LOGGER.error("Exception While Fetching User " + ex);
			ErrorMessage errorMessage = UserUtil.getErrorModel("Exception While Creating User " + ex,
					HttpStatus.INTERNAL_SERVER_ERROR);
			response = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
}
