package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.UserData;
import com.example.service.UserService;

import com.example.entity.User;
//import com.example.service.UserService;
//import com.example.valueobject.ReponseTemplateVo;

@RestController
@RequestMapping("/api/")
public class SupervisorsController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/submit")
	public User saveUser(@RequestBody User user) {
		System.out.println("Inside save User");
		System.out.println("user "+user.getFirstName());
		System.out.println("user "+user.getLastName());
		System.out.println("user "+user.getPhoneNumber());
		System.out.println("user "+user.getSupervisor());
		return userService.saveDepartement(user);
	}
	
	@GetMapping("/supervisors")
	public List<User> getUserWithDepartment() {
		System.out.println("Inside findUser By Id ");
		return userService.getAllUser();
		
	}
	
}
