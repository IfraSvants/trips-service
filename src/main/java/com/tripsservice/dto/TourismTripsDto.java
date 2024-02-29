package com.tripsservice.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TourismTripsDto {

	Integer tripId;

	String tripDate;

	String tripTime;
	
	String places;
	
	String ville;
	
}
