package com.example.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.entity.User;
import com.example.model.UserData;
import com.example.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveDepartement(User user) {
		System.out.println("inside the UserService method of save user");
//		User u =  new User();
//		u.setFirstName(user.getFirstName());
//		u.setLastName(user.getLastName());
//		u.setEmail(user.getEmail());
//		u.setPhoneNumber(user.getPhoneNumber());
//		//u.setSupervisor(user.getSupervisor());
//		u.setSupervisor("");
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	

}
