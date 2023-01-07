package com.saraya.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saraya.dto.CoachDTO;
import com.saraya.dto.LoginDTO;
import com.saraya.entity.CoachEntity;
import com.saraya.exception.ExceptionConstants;
import com.saraya.exception.WecareExeception;
import com.saraya.repository.CoachRepository;

@Service
public class CoachService {
	@Autowired
	public CoachRepository coachRepository;
	
	public String saveCoach(CoachDTO coachDTO) {
		CoachEntity coach = new CoachEntity();
		coach.setPassword(coachDTO.getPassword());
		coach.setName(coachDTO.getName());
		coach.setDateOfBirth(coachDTO.getDateOfBirth());
		coach.setGender(coachDTO.getGender());
		coach.setMobileNumber(coachDTO.getMobileNumber());
		coach.setSpeciality(coachDTO.getSpeciality());
		 coachRepository.save(coach);
		 return "your coach id is "  + coach.getCoachId();
	}
	
	public Boolean loginCoach(LoginDTO loginDTO )throws WecareExeception{
		Optional<CoachEntity> optional = coachRepository.findByCoachId(loginDTO.getId());
		CoachEntity coach = null;
		if(optional.isPresent()) {
			coach = optional.get();
		}
		if(coach!= null && coach.getPassword().equals(loginDTO.getPassword())) {
			return  true;
			
		}
		throw new WecareExeception(ExceptionConstants.COACH_NOT_FOUND.toString());
	}
	
	public CoachDTO getCoachProfile(String id) {
		 CoachEntity coach = coachRepository.findByCoachId(id).get();
		 if(coach != null) {
			return new CoachDTO(coach.getCoachId(),
				coach.getPassword(),
				coach.getName(),
				coach.getDateOfBirth(),
				coach.getGender(),
				coach.getMobileNumber(),
				coach.getSpeciality()
					);
		 }
		 return null;
	}
	
	public List<CoachDTO> showAllCoaches(){
		List<CoachEntity> listCoach = coachRepository.findAll();
		List<CoachDTO> listDTO = new ArrayList<>();
		for(CoachEntity coachEntity :listCoach) {
			
			CoachDTO coachDTO = new CoachDTO();
			coachDTO.setCoachId(coachEntity.getCoachId());
			coachDTO.setPassword(coachEntity.getPassword());
			coachDTO.setName(coachEntity.getName());
			coachDTO.setDateOfBirth(coachEntity.getDateOfBirth());
			coachDTO.setGender(coachEntity.getGender());
			coachDTO.setMobileNumber(coachEntity.getMobileNumber());
			coachDTO.setSpeciality(coachEntity.getSpeciality());
			
			listDTO.add(coachDTO);
		}
		return listDTO;
	}
	
	

}
