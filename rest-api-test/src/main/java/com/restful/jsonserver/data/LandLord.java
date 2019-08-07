package com.restful.jsonserver.data;

public class LandLord {

	private String firstName;
	private String lastName;
	private Boolean trusted;
	
	public LandLord(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public LandLord(String firstName, String lastName, Boolean trusted) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.trusted = trusted;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Boolean getTrusted() {
		return trusted;
	}

	public void setTrusted(Boolean trusted) {
		this.trusted = trusted;
	}	
}