package com.example.demo.Controller;

import javax.validation.Valid;

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

import com.example.demo.Entity.User;
import com.example.demo.Entity.UserModel;
import com.example.demo.Service.UserInterface;

@RestController
public class UserController {
	@Autowired
	UserInterface userservice;
	@PostMapping("/Register")
public ResponseEntity<User> CreateUser(@Valid @RequestBody UserModel user ) {
	return new ResponseEntity<User>(userservice.createUser(user),HttpStatus.CREATED);
	
}
	@GetMapping("/User/{id}")
	public ResponseEntity<User> GetUserByID(@PathVariable Long id) {
		return new ResponseEntity<User>(userservice.readUser(id),HttpStatus.OK);
		}
	
	@PutMapping("/User/{id}")
	public ResponseEntity<User> updateUser(@Valid @RequestBody UserModel User,@PathVariable Long id)
	{
		return new ResponseEntity<User>(userservice.updateUser(User, id), HttpStatus.OK);
		
	}
	@DeleteMapping("/User/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id) {
		userservice.deleteUser(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	
}
