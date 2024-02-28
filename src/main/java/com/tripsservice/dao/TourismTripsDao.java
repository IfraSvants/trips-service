package com.tripsservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tripsservice.models.TourismTripsEntity;

public interface TourismTripsDao extends JpaRepository< TourismTripsEntity, Integer > {

	
	
}
