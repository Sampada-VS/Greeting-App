package com.blz.greetingapp.service;

import com.blz.greetingapp.model.Greeting;
import com.blz.greetingapp.model.User;

public interface IGreetingService {

	public Greeting addGreeting(User user);
}
