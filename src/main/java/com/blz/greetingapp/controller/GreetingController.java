package com.blz.greetingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blz.greetingapp.model.Greeting;
import com.blz.greetingapp.model.User;
import com.blz.greetingapp.service.IGreetingService;

@RestController
@RequestMapping("/greetings")
public class GreetingController {
	@Autowired
	private IGreetingService greetingService;

	@GetMapping("/get")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		User user = new User();
		user.setFirstName(name);
		return greetingService.addGreeting(user);
	}

}
