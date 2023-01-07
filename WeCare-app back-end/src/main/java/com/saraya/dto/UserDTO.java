package com.saraya.dto;

import java.time.LocalDate;


import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class UserDTO {

	private String userId;
	@NotNull(message="Cannot be null, minimum length should be 5 and maximum length should be 10")
	private String name;
	@NotNull(message="Cannot be null, minimum length should be 3 and maximum length should be 50")
	private String password;
	private char gender;
	@DateTimeFormat(pattern="dd-MM-yyy")
	private LocalDate dateOfBirth;
	@NotNull(message="Cannot be null, minimum length should be 10 and maximum length should be 10.")
	private long mobileNumber ;
	@NotNull(message="Should be a valid email")
	private String email;
	@NotNull(message="Cannot be null, minimum length should be 6 and maximum length should be 6")
	private int pincode;
	@NotNull(message="Cannot be null, minimum length should be 3 and maximum length should be 20")
	private String city;
	@NotNull(message="Cannot be null, minimum length should be 3 and maximum length should be 20")
	private String state;
	@NotNull(message="Cannot be null, minimum length should be 3 and maximum length should be 20")
	private String country;
	public UserDTO(String userId, String name, String password, char gender, LocalDate dateOfBirth,
			long mobileNumber, String email, int pincode, String city, String state, String country) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.pincode = pincode;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	public UserDTO() {
		super();
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", name=" + name + ", password=" + password + ", gender=" + gender
				+ ", dateOfBirth=" + dateOfBirth + ", mobileNumber=" + mobileNumber + ", email=" + email + ", pincode="
				+ pincode + ", city=" + city + ", state=" + state + ", country=" + country + "]";
	}
	

}
