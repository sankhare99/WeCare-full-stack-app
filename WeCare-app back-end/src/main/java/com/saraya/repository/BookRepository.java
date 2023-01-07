package com.saraya.repository;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.saraya.entity.BookingEntity;

@Repository
public interface BookRepository extends JpaRepository<BookingEntity,Integer>{
    @Query("select zy from BookingEntity zy where zy.userId=?1 and zy.appointmentDate=?2 and zy.slot=?3")
	BookingEntity findAllBooking(String userId,LocalDate appointmentDate,String slot);
    
    Optional<BookingEntity>findByUserId(String userId);
    List<BookingEntity>findBookingByUserId(String userId); 
    List<BookingEntity>findBookingByCoachId(String coachId); 

}
