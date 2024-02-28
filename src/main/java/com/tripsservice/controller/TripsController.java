package com.tripsservice.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tripsservice.dto.TourismTripsDto;
import com.tripsservice.service.facade.TourismTripsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/tourismTrips")
public class TripsController {
	
	final static Logger log = LogManager.getLogger(TripsController.class);

	@Autowired
	private TourismTripsService tourismTripsService;
	
	@GetMapping("")
	public ResponseEntity<List<TourismTripsDto>> findAll(){
		
		return new ResponseEntity<>(tourismTripsService.findAll(), HttpStatus.OK);
		
	}
	
	@GetMapping("/tripDate/{tripDate}")
	public ResponseEntity<List<TourismTripsDto>> findByTripDate( @PathVariable("tripDate") String tripDate){
		
		String formattedDate = formatDate(tripDate);
		System.out.println(formattedDate);
		return new ResponseEntity<>(tourismTripsService.findByTripDate(formattedDate), HttpStatus.OK);
		
	}
	
	@PostMapping("")
	public ResponseEntity<TourismTripsDto> save(@Valid @RequestBody() TourismTripsDto tourismTripsDto){
		
		TourismTripsDto saved = tourismTripsService.save(tourismTripsDto);
		return ResponseEntity.accepted().body(saved);
		
	}
	
	@GetMapping("/id/{id}")
    public ResponseEntity<TourismTripsDto> findById( @PathVariable("id") Integer id) {
		
		TourismTripsDto tourismTripsDto = tourismTripsService.findById(id);
    	return ResponseEntity.ok(tourismTripsDto);
    	
    }
	
	@DeleteMapping("/id/{id}")
	public ResponseEntity<?> delete( @PathVariable("id") Integer id) {
		
		tourismTripsService.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	public static String formatDate(String inputDate) {
		
        try {
        	
            DateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = inputDateFormat.parse(inputDate);

            DateFormat outputDateFormat = new SimpleDateFormat("yyyy/MM/dd");
            return outputDateFormat.format(date);
            
        } catch (ParseException e) {
        	
            e.printStackTrace();
            return null;
            
        }
    }
	
}
