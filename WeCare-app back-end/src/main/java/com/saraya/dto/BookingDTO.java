package com.saraya.dto;


import java.time.LocalDate;




public class BookingDTO {
	
	private int bookingId;
	private String userId;
	private String coachId;
	private String slot;
	private LocalDate appointmentDate;
	
	public BookingDTO(int bookingId, String userId, String coachId, String slot,LocalDate appointmentDate) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.coachId = coachId;
		this.slot = slot;
		this.appointmentDate = appointmentDate;
	}

	public BookingDTO() {
		super();
	}

	public BookingDTO(Integer bookingId, String userId, LocalDate appointmentDate, String slot) {
		// TODO Auto-generated constructor stub
		this.bookingId = bookingId;
		this.userId = userId;
		this.slot = slot;
		this.appointmentDate = appointmentDate;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
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
