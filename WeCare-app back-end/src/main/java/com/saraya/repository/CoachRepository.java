package com.saraya.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saraya.entity.CoachEntity;


public interface CoachRepository extends JpaRepository<CoachEntity,String>{
	Optional<CoachEntity>findByCoachId(String coachId);

}
