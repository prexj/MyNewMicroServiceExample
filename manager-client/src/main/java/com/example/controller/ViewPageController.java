package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewPageController {
	
	@GetMapping("/")
	public String home(Model model) {
		System.out.println("starting page load :::: ");
		return "emp";
	}

}
