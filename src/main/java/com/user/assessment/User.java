package com.user.assessment;

public class User {
	private String username;
	private String email;
	private String address;

	public User(String username, String email, String address) {
		this.username = username;
		this.email = email;
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}
}