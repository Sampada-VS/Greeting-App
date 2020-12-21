package com.blz.greetingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping("/get/{id}")
	public Greeting getGreeting(@PathVariable(name = "id") long id) {
		return greetingService.getGreetingById(id);
	}

	@GetMapping("/get/list")
	public List<Greeting> listGreeting() {
		return greetingService.getGreetingList();
	}

	@PutMapping("/edit/{id}")
	public Greeting editGreeting(@RequestBody User user, @PathVariable(name = "id") long id) {
		Greeting greet = greetingService.getGreetingById(id);
		if (greet != null) {
			user.setFirstName(user.getName());
			return greetingService.updateGreeting(user,id);
		}
		return null;
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteGreeting(@PathVariable(name = "id") long id) {
		greetingService.deleteGreeting(id);
	}

}
