package com.sana.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sana.user.model.User;
import com.sana.user.repository.UserRepository;

@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	public List<User> getListUsers() {

		return userRepository.findAll();
	}

	@Override
	public void saveAndUpdate(User user) {
		userRepository.save(user);
		
	}

	@Override
	public void deleteUser(String id) {
		userRepository.deleteById(id);
		
	}

	@Override
	public User getUserById(String id) {
		return userRepository.findById(id).get();
				
	}

}
