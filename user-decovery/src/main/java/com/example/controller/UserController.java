//package com.example.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.entity.User;
//import com.example.service.UserService;
//import com.example.valueobject.ReponseTemplateVo;
//
//import lombok.extern.log4j.Log4j2;
//
//@RestController
//@RequestMapping("/users/")
//public class UserController {
//	
//	@Autowired
//	private UserService userService;
//	
//	
//	@PostMapping("/")
//	public User saveUser(@RequestBody User user) {
//		System.out.println("Inside save User");
//		return userService.saveDepartement(user);
//	}
//	
//	@GetMapping("/{userId}/")
//	public ReponseTemplateVo getUserWithDepartment(@PathVariable("userId") Long userId) {
//		System.out.println("Inside findUser By Id ");
//		return userService.getUserWithDepartment(userId);
//		
//	}
//	
//}
