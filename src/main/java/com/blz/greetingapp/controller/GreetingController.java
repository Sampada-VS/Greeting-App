package com.blz.greetingapp.controller;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blz.greetingapp.model.Greeting;

@RestController
public class GreetingController {
	private static final String template="Hello, %s !";
	private final AtomicLong counter=new AtomicLong();
		
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name",required = false) String name,@RequestParam(value="lname",required = false) String lname) {
		if(name==null && lname==null) {
			String msg="World";
			return new Greeting(counter.incrementAndGet(),String.format(template, msg));
		}
		if(name==null) {
			return new Greeting(counter.incrementAndGet(),String.format(template, lname));
		}
		if(lname==null) {
			return new Greeting(counter.incrementAndGet(),String.format(template, name));
		}
		return null;
	}
	
	@PostMapping("/greeting")
	public Greeting greetingPost(@RequestBody Greeting greet) {
		return new Greeting(counter.incrementAndGet(),
				String.format(template, greet.getContent()));
	}
	
	@PutMapping("/greeting/{id}")
	public Greeting greetingPut(@PathVariable("id") long id,@RequestBody Greeting greet) {
		return new Greeting(id,
				String.format(template, greet.getContent()));
	}

}
