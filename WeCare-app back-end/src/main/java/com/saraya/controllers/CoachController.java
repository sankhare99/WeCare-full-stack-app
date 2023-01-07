package com.saraya.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saraya.dto.BookingDTO;
import com.saraya.dto.CoachDTO;
import com.saraya.dto.ErrorMessage;
import com.saraya.dto.LoginDTO;
import com.saraya.exception.WecareExeception;
import com.saraya.services.BookService;
import com.saraya.services.CoachService;


@RestController
@RequestMapping("/coachs")
public class CoachController {
	
	@Autowired
	public CoachService coachService;
	@Autowired
	public BookService bookService;
	
	@PostMapping("/save")
	
	public ResponseEntity createCoach( @Valid  @RequestBody CoachDTO coachDTO , Errors errors) {
		String response ="";
		if(errors.hasErrors()) {
			response = errors.getAllErrors().stream().map(ObjectError::getDefaultMessage)
					.collect(Collectors.joining(";"));
			ErrorMessage errorMessage = new ErrorMessage();
			errorMessage.setMessage(response);
			return ResponseEntity.ok(errorMessage);
		}
		response = coachService.saveCoach(coachDTO);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Boolean>loginCoach(@RequestBody  @Validated  LoginDTO loginDTO )
			throws WecareExeception{
		
		if(!coachService.loginCoach(loginDTO)) {
			return ResponseEntity.ok(false);
		}else {
			boolean coachFound = coachService.loginCoach(loginDTO);
			return ResponseEntity.ok(coachFound);
		}
		
	}
	@GetMapping("/profile/{coachId}")
	public ResponseEntity<CoachDTO>getCoachProfile(@PathVariable  String coachId){
		return ResponseEntity.ok(coachService.getCoachProfile(coachId));
	}
	@GetMapping("/showAll")
	public List<CoachDTO>showAllCoaches(){
		return coachService.showAllCoaches();
	}
	@GetMapping("/booking/{coachId}")
	public ResponseEntity<List<BookingDTO>> findBookingByCoachId( @PathVariable String coachId){
	return ResponseEntity.ok(bookService.findBookingByCoachId(coachId));
		
	}
	
	
}
