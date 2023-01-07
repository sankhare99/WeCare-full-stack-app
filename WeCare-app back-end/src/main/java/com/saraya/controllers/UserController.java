package com.saraya.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saraya.dto.BookingDTO;
import com.saraya.dto.ErrorMessage;
import com.saraya.dto.LoginDTO;
import com.saraya.dto.UserDTO;
import com.saraya.entity.UserEntity;
import com.saraya.exception.WecareExeception;
import com.saraya.services.BookService;
import com.saraya.services.UserEntitySevice;


@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
 public	UserEntitySevice userEntitySevice;
	@Autowired
	public BookService bookService;

	
	
	@PostMapping("/save")
	
	public ResponseEntity createUser(@Valid @RequestBody UserDTO userDto ,Errors errors ) {
		String response = "";
		if(errors.hasErrors()) {
			response = errors.getAllErrors().stream().map(ObjectError::getDefaultMessage)
			.collect(Collectors.joining(";"));		
			ErrorMessage errorMessage = new ErrorMessage();
			errorMessage.setMessage(response);
			return ResponseEntity.ok(errorMessage);
		}
		response = userEntitySevice.createUser(userDto);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Boolean>loginUser( @Valid @RequestBody LoginDTO loginDTO )throws WecareExeception{
		
		if(!userEntitySevice.loginUser(loginDTO)) {
			return ResponseEntity.ok(false);
		}else {
			boolean userFound = userEntitySevice.loginUser(loginDTO);
			return ResponseEntity.ok(userFound);
		}
		
	}
	@GetMapping("/user/{userId}")
	public ResponseEntity<UserDTO>getUserProfile(@PathVariable  String userId){
		return ResponseEntity.ok(userEntitySevice.getUserProfile(userId));
		
	}
	@GetMapping("/booking/{userId}")
	public ResponseEntity<List<BookingDTO>> findBookingByUserId(@PathVariable String userId){
	return ResponseEntity.ok(bookService.findBookingByUserId(userId));
		
	}
	
	@GetMapping("/listUser")
	public List<UserEntity> ListUser(){
		return userEntitySevice.ListUser();
	}

}
