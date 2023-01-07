package com.saraya.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saraya.dto.BookingDTO;
import com.saraya.entity.BookingEntity;
import com.saraya.entity.CoachEntity;
import com.saraya.entity.UserEntity;
import com.saraya.exception.ExceptionConstants;
import com.saraya.exception.WecareExeception;
import com.saraya.repository.BookRepository;
import com.saraya.repository.CoachRepository;
import com.saraya.repository.UserRepository;
import com.saraya.utility.MailUtility;

@Service
public class BookService {
	
	@Autowired
	public BookRepository bookRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	CoachRepository coachRepository;
	@Autowired
	MailUtility mailUtility;
	
	public Boolean bookAppointment( String userId, String coachId,LocalDate appointmentDate,String slot ) throws WecareExeception{
		  BookingEntity nbook = new BookingEntity(userId,coachId,appointmentDate,slot);
		  BookingEntity book= bookRepository.findAllBooking(userId, appointmentDate, slot);
		        Optional<UserEntity> user = userRepository.findByUserId(userId);
		        UserEntity userEntity = null;


		        if (user.isPresent()) {
		        	userEntity = user.get();
		        }

		        Optional<CoachEntity> coach = coachRepository.findByCoachId(coachId);

		        CoachEntity coachEntity = null;

		        if (coach.isPresent()) {
		        	coachEntity = coach.get();
		        }
		        if(book!= null) {
			  throw new WecareExeception(ExceptionConstants.BOOKING_ALREADY_EXISTS.toString()); 
		  }else {
			  bookRepository.save(nbook);
			  mailUtility.sendSchedulingEmail(userEntity.getName(), coachEntity.getName(),userEntity.getEmail(), nbook.getBookingId(), nbook.getSlot(), nbook.getAppointmentDate());
			  return true;
	     }
	} 

	public boolean RescheduleAppointment(Integer bookingId, LocalDate appointmentDate, String slot){
		BookingEntity bookingRef = bookRepository.getReferenceById(bookingId);
		String userId = bookingRef.getUserId();
		BookingEntity allBookings = bookRepository.findAllBooking(userId, appointmentDate, slot);
		BookingEntity newbook = new BookingEntity(bookingRef.getCoachId(),userId,appointmentDate,slot);

        Optional<UserEntity> user = userRepository.findByUserId(bookingRef.getUserId());
        UserEntity userEntity = null;


        if (user.isPresent()) {
        	userEntity = user.get();
        }

        Optional<CoachEntity> coach = coachRepository.findByCoachId(bookingRef.getCoachId());

        CoachEntity coachEntity = null;

        if (coach.isPresent()) {
            coachEntity = coach.get();
        }

		if( allBookings == null) {
			 bookRepository.save(newbook);
			 mailUtility.sendReschedulingEmail(userEntity.getName(), coachEntity.getName(),userEntity.getEmail(), newbook.getBookingId(), newbook.getSlot(), newbook.getAppointmentDate());
			 return true;
		}else {
			return false;
		}
		 
	}
	public void cancelAppointment(Integer bookingId) {
		BookingEntity booking = bookRepository.getReferenceById(bookingId);
		 Optional<UserEntity> user = userRepository.findByUserId(booking.getUserId());
	        UserEntity userEntity = null;


	        if (user.isPresent()) {
	            userEntity = user.get();
	        }

	        Optional<CoachEntity> coach = coachRepository.findByCoachId(booking.getCoachId());

	        CoachEntity coachEntity = null;

	        if (coach.isPresent()) {
	            coachEntity = coach.get();
	        }

		mailUtility.sendCancellingEmail(userEntity.getName(), coachEntity.getName(),userEntity.getEmail(), booking.getBookingId(), booking.getSlot(), booking.getAppointmentDate());
		bookRepository.deleteById(booking.getBookingId());
	}
	public BookingDTO findByBookingId(Integer bookingId){
	BookingEntity bookingRef = bookRepository.getReferenceById(bookingId);
	BookingDTO booktdo = new BookingDTO(bookingRef.getBookingId(), bookingRef.getUserId(), bookingRef.getCoachId(),bookingRef.getSlot(),bookingRef.getAppointmentDate());

    return booktdo;
	}
	public List<BookingDTO> findBookingByUserId(String userId){
		 List<BookingEntity> listbooking = bookRepository.findBookingByUserId(userId);

	        List<BookingDTO> listbookDto = new ArrayList<>();

	        for (BookingEntity bookEntity: listbooking) {
	        	BookingDTO bookDto = new BookingDTO(bookEntity.getBookingId(), bookEntity.getUserId(), bookEntity.getCoachId(), bookEntity.getSlot(), bookEntity.getAppointmentDate());
	            listbookDto.add(bookDto);

	        }
	        return  listbookDto;
	    }
		
	public  List<BookingDTO> findBookingByCoachId(String coachId){
	List<BookingEntity>listbooking = bookRepository.findBookingByCoachId(coachId);
	List<BookingDTO> listbookDto = new ArrayList<>();
	for (BookingEntity bookEntity: listbooking) {
    	BookingDTO bookDto = new BookingDTO(bookEntity.getBookingId(), bookEntity.getUserId(), bookEntity.getCoachId(), bookEntity.getSlot(), bookEntity.getAppointmentDate());
        listbookDto.add(bookDto);
	}
	return  listbookDto;
}
}	

