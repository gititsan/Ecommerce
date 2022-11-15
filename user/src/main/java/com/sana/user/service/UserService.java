package com.sana.user.service;

import java.util.List;

import com.sana.user.model.User;

public interface UserService {

	public List<User> getListUsers();

	public void saveAndUpdate(User User);

	public void deleteUser(String id);

	public User getUserById(String id);
}
