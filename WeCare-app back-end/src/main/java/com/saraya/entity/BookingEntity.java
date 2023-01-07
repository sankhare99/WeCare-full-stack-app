package com.saraya.entity;


import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class BookingEntity {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer bookingId;
	private String userId;
	private String coachId;
	private String slot;
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private LocalDate appointmentDate;
	
	public BookingEntity(Integer bookingId, String userId, String coachId, String slot, LocalDate appointmentDate) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.coachId = coachId;
		this.slot = slot;
		this.appointmentDate = appointmentDate;
	}

	public BookingEntity() {
		super();
	}

	public BookingEntity( String userId,String coachId,LocalDate appointmentDate, String slot) {
		// TODO Auto-generated constructor stub
		this.userId = userId;
		this.coachId = coachId;
		this.slot = slot;
		this.appointmentDate = appointmentDate;
	}

	public BookingEntity(Integer bookingId, LocalDate appointmentDate, String slot) {
		// TODO Auto-generated constructor stub
		this.bookingId = bookingId;
		this.slot = slot;
		this.appointmentDate = appointmentDate;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCoachId() {
		return coachId;
	}

	public void setCoachId(String coachId) {
		this.coachId = coachId;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	@Override
	public String toString() {
		return "BookingEntity [bookingId=" + bookingId + ", userId=" + userId + ", coachId=" + coachId + ", slot="
				+ slot + ", appointmentDate=" + appointmentDate + "]";
	}

		
	

	
}

