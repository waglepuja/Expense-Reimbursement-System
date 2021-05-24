package com.project1.model;

public class Credentials {

private String username;
	
	private String Password;

	public Credentials() {
		super();
	}

	public Credentials(String username, String password) {
		super();
		this.username = username;
		Password = password;
	}
	
	//Getters and Setters

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@Override
	public String toString() {
		return "Credentials [username=" + username + ", Password=" + Password + "]";
	}
	
	
	
}
