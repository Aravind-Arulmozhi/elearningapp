package com.example.demo.Service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.UserRepository;
import com.example.demo.Entity.User;
import com.example.demo.Entity.UserModel;
import com.example.demo.Exceptions.ItemAlreadyExistsException;
import com.example.demo.Exceptions.ResourceNotFoundException;
@Service
public class UserServiceImpl implements UserInterface {
@Autowired
UserRepository userRepository;
	@Override
	public User createUser(UserModel user) {
		// TODO Auto-generated method stub
		if(userRepository.existsByEmail(user.getEmail()))
		{
			throw new ItemAlreadyExistsException("user already exists :" + user.getEmail());
		}
		User newUser = new User();
		BeanUtils.copyProperties(user, newUser);
		return userRepository.save(newUser);
	}

	@Override
	public User readUser(Long id) {
		Optional<User> user= userRepository.findById(id);
		if (user.isPresent())
		{
			return user.get();
		}
		else
		{
			throw new ResourceNotFoundException("user is not found " + id);
		}
	}

	@Override
	public User updateUser(UserModel user, Long id) {
		// TODO Auto-generated method stub
		User existingUser=readUser(id);
		existingUser.setName(user.getName() != null ? user.getName() : existingUser.getName());
		existingUser.setEmail(user.getEmail() != null ? user.getEmail() : existingUser.getEmail());
		existingUser.setPassword(user.getPassword() != null ? user.getPassword() : existingUser.getPassword());
		existingUser.setAge(user.getAge() != null ? user.getAge() : existingUser.getAge());
		return userRepository.save(existingUser);

	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		User existingUser=readUser(id);
		userRepository.delete(existingUser);
	}

}
