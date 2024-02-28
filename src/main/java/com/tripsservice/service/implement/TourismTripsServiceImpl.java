package com.tripsservice.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.tripsservice.dao.TourismTripsDao;
import com.tripsservice.dto.TourismTripsDto;
import com.tripsservice.exception.EntityNotFoundException;
import com.tripsservice.models.TourismTripsEntity;
import com.tripsservice.service.facade.TourismTripsService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TourismTripsServiceImpl implements TourismTripsService {

	private ModelMapper modelMapper;
	private TourismTripsDao tourismTripsDao;
	
	@Override
	public List<TourismTripsDto> findAll() {
		return tourismTripsDao
				.findAll()
				.stream().map( el->modelMapper.map(el, TourismTripsDto.class) )
				.collect(Collectors.toList())
				;
	}

	@Override
	public TourismTripsDto save(TourismTripsDto tourismTripsDto) {
		
		TourismTripsEntity entity = modelMapper.map(tourismTripsDto, TourismTripsEntity.class);
		
		TourismTripsEntity saved = tourismTripsDao.save(entity);
		
		return modelMapper.map(saved, TourismTripsDto.class);
	}

	@Override
	public TourismTripsDto update(TourismTripsDto tourismTripsDto, Integer id) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TourismTripsDto findById(Integer id) {
		
		TourismTripsEntity tourismTripsEntity = tourismTripsDao.findById(id).orElseThrow( ()->new EntityNotFoundException("Tourism Trips Not Found"));
		return modelMapper.map( tourismTripsEntity , TourismTripsDto.class );
		
	}

	@Override
	public void delete(Integer id) {

		TourismTripsEntity tourismTripsEntity = tourismTripsDao.findById(id).orElseThrow( ()->new EntityNotFoundException("Tourism Trips Not Found"));
		tourismTripsDao.delete(tourismTripsEntity);
		
	}

	@Override
	public List<TourismTripsDto> findByTripDate(String tripDate) {
		
		return tourismTripsDao
				.findByTripDate(tripDate)
				.stream().map( el->modelMapper.map(el, TourismTripsDto.class) )
				.collect(Collectors.toList())
				;
	}
	
}
