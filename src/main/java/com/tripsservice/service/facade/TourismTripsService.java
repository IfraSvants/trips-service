package com.tripsservice.service.facade;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.tripsservice.dto.TourismTripsDto;


public interface TourismTripsService {
	
	List<TourismTripsDto> findAll();
	
	List<TourismTripsDto> findByTripDate(String tripDate);
	
	List<TourismTripsDto> findByVilleAndTripDate(String ville, String tripDate);
	
	TourismTripsDto save( TourismTripsDto tourismTripsDto );
	
	TourismTripsDto update( TourismTripsDto tourismTripsDto , Integer id ) throws NotFoundException;
	
	TourismTripsDto findById( Integer id );
	
	void delete( Integer id );

}
