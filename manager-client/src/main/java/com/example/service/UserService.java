package com.example.service;

import java.util.List;

import com.example.entity.User;
import com.example.model.UserData;

public interface UserService {

	public User saveDepartement(User user);

	public List<User> getAllUser();

}
