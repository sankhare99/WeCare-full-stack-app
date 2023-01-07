package com.saraya.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

public class CoachDTO {
	
	private String coachId;
	@NotNull(message="Cannot be null, minimum length should be 5 and maximum length should be 10")
	private String password;
	@NotNull(message="Cannot be null, minimum length should be 3 and maximum length should be 50")
	private String name;
	private LocalDate dateOfBirth;
	private char gender;
	@NotNull(message="Cannot be null, minimum length should be 10 and maximum length should be 10")
	private long mobileNumber;
	@NotNull(message="Cannot be null, minimum length should be 3 and maximum length should be 50")
	private String speciality;
	
	
	public CoachDTO(String coachId, String password, String name, LocalDate dateOfBirth, char gender, long mobileNumber,
			String speciality) {
		super();
		this.coachId = coachId;
		this.password = password;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.speciality = speciality;
	}
	
	
	public CoachDTO() {
		super();
		// TODO Auto-generated constructor stub
	}




	public String getCoachId() {
		return coachId;
	}


	public void setCoachId(String coachId) {
		this.coachId = coachId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public char getGender() {
		return gender;
	}


	public void setGender(char gender) {
		this.gender = gender;
	}


	public long getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getSpeciality() {
		return speciality;
	}


	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}


	@Override
	public String toString() {
		return "CoachDTO [coachId=" + coachId + ", password=" + password + ", name=" + name + ", dateOfBirth="
				+ dateOfBirth + ", gender=" + gender + ", mobileNumber=" + mobileNumber + ", speciality=" + speciality
				+ "]";
	}
	
	
	


}
