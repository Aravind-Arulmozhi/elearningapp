package com.example.demo.Service;

import com.example.demo.Entity.User;
import com.example.demo.Entity.UserModel;

public interface UserInterface {
	User createUser(UserModel user);
	
	User readUser(Long id);
	
	User updateUser(UserModel user, Long id);
	
	void deleteUser(Long id);

}
