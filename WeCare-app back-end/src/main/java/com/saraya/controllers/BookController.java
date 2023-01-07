package com.saraya.controllers;


import java.time.LocalDate;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.saraya.exception.WecareExeception;
import com.saraya.services.BookService;
 @RestController
 @RequestMapping("/book")
public class BookController {
	
	@Autowired
	public BookService bookService;
	@PostMapping("/BookingId/{userId}/{coachId}")
	public ResponseEntity<Boolean> bookAppointment(@PathVariable String userId, @PathVariable String coachId, @RequestParam  @DateTimeFormat(pattern = "yyyy-MM-dd")   
	LocalDate appointmentDate, @RequestParam String slot) throws WecareExeception {
	return ResponseEntity.ok(bookService.bookAppointment(userId,coachId,appointmentDate,slot)); 
	}
	
	@PutMapping("/reschedule/{bookingId}")
    public ResponseEntity<Boolean> rescheduleAppointment( @PathVariable Integer bookingId, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate appointmentDate, @RequestParam String slot){
	  return ResponseEntity.ok(bookService.RescheduleAppointment(bookingId,appointmentDate,slot));	
}
	@DeleteMapping("/delete/{bookingId}")
    public ResponseEntity<?> cancelAppointment(@PathVariable Integer bookingId){
	bookService.cancelAppointment(bookingId);
     return ResponseEntity.noContent().build();
	}
	
	
	}
 
