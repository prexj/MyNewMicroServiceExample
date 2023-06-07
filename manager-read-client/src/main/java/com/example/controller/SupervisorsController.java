package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.communication.SuperviserServiceCommunication;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

//import com.example.entity.User;
//import com.example.service.UserService;
//import com.example.valueobject.ReponseTemplateVo;

@RestController
@RequestMapping("/api/")
public class SupervisorsController {
	
	@Autowired
	private SuperviserServiceCommunication superviserServiceCommunication;
	
	
	@GetMapping("/supervisors")
	public List<User> getUserWithDepartment() throws JsonMappingException, JsonProcessingException {
		System.out.println("Inside findUser By Id ");
		return superviserServiceCommunication.getSupervisorInfo();
		
	}
	
}
