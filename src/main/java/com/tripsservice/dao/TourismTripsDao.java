package com.tripsservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tripsservice.models.TourismTripsEntity;
import java.util.List;


public interface TourismTripsDao extends JpaRepository< TourismTripsEntity, Integer > {

	List<TourismTripsEntity> findByTripDate(String tripDate);
	
}
