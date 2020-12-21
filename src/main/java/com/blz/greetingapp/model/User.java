package com.blz.greetingapp.model;

public class User {
	private String name;

	public void setFirstName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
