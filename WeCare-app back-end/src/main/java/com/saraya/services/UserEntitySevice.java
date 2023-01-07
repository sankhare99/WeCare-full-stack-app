package com.saraya.services;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saraya.dto.LoginDTO;
import com.saraya.dto.UserDTO;
import com.saraya.entity.UserEntity;
import com.saraya.exception.ExceptionConstants;
import com.saraya.exception.WecareExeception;
import com.saraya.repository.UserRepository;


@Service
public class UserEntitySevice {

	@Autowired
	public UserRepository userRepository;

	public String createUser(UserDTO userDto) {
		UserEntity user = new UserEntity();
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		user.setGender(userDto.getGender());
		user.setDateOfBirth(userDto.getDateOfBirth());
		user.setMobileNumber(userDto.getMobileNumber());
		user.setEmail(userDto.getEmail());
		user.setPincode(userDto.getPincode());
		user.setCity(userDto.getCity());
		user.setState(userDto.getState());
		user.setCountry(userDto.getCountry());
		 userRepository.save(user);
		 return "your user id is " + user.getUserId();

	}
	public Boolean loginUser(LoginDTO loginDTO) throws WecareExeception {
	Optional<UserEntity> optional = userRepository.findByUserId(loginDTO.getId());
     UserEntity user = null;
    if (optional.isPresent()) {
    user = optional.get();
    }
   	if(user!= null && user.getPassword().equals(loginDTO.getPassword())) {
   	
    	return true;
   }
	throw new WecareExeception(ExceptionConstants.USER_NOT_FOUND.toString());
}
	
	public UserDTO getUserProfile(String id) {
		UserEntity user = userRepository.findByUserId(id).get();
		if(user != null) {
			return new UserDTO(user.getUserId(),
			user.getName(),
			user.getPassword(),
			user.getGender(),
			user.getDateOfBirth(),
			user.getMobileNumber(),
			user.getEmail(),
			user.getPincode(),
			user.getCity(),
			user.getState(),
			user.getCountry()
			
			);
		}
		return null;
		
	}
	
	
	public List<UserEntity> ListUser() {
		return userRepository.findAll();
		
	}

}

