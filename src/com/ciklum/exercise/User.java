package com.ciklum.exercise;

public class User {
	
	private String firstName;
	private String secondName;
	private Boolean registered;
	
	public User(String fullName) {
		String[] fullNameTokens = fullName.split("\\s+");
		Integer lastTokenPosition = new Integer(fullNameTokens.length - 1); //Last token position will match second name
		firstName = fullNameTokens[0];
		secondName = fullNameTokens[lastTokenPosition];
		registered = Boolean.FALSE;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getSecondName() {
		return secondName;
	}
	
	public Boolean isRegistered() {
		return registered;
	}
	
	public void isRegistered(Boolean registered) {
		this.registered = registered;
	}
}
