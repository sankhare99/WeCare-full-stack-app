package com.saraya.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.saraya.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,String> {

	Optional<UserEntity>findByUserId(String userId);

}
