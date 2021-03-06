package com.blz.greetingapp.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blz.greetingapp.model.Greeting;
import com.blz.greetingapp.model.User;
import com.blz.greetingapp.repository.GreetingRepository;

@Service
public class GreetingService implements IGreetingService {

	private static final String template = "Hello, %s !";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private GreetingRepository greetingRepository;

	@Override
	public Greeting addGreeting(User user) {
		String message = String.format(template, (user.toString().isEmpty()) ? "Hello World" : user.toString());
		return greetingRepository.save(new Greeting(counter.incrementAndGet(), message));
	}

	@Override
	public Greeting getGreetingById(long id) {
		return greetingRepository.findById(id).get();
	}

	public List<Greeting> getGreetingList() {
		return greetingRepository.findAll();
	}

	@Override
	public Greeting updateGreeting(User user, long id) {
		String message = String.format(template, (user.toString().isEmpty()) ? "Hello World" : user.toString());
		return greetingRepository.save(new Greeting(id, message));
	}

	@Override
	public void deleteGreeting(long id) {
		greetingRepository.deleteById(id);
	}

}
