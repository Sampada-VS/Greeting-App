package com.blz.greetingapp.service;

import java.util.List;

import com.blz.greetingapp.model.Greeting;
import com.blz.greetingapp.model.User;

public interface IGreetingService {

	public Greeting addGreeting(User user);

	public Greeting getGreetingById(long id);

	public List<Greeting> getGreetingList();

	public Greeting updateGreeting(User user, long id);

}
