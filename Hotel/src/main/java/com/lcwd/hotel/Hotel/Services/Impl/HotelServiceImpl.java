package com.lcwd.hotel.Hotel.Services.Impl;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.hotel.Hotel.Entities.Hotel;
import com.lcwd.hotel.Hotel.Exception.ResourceNotFoundException;
import com.lcwd.hotel.Hotel.Repository.HotelRepository;
import com.lcwd.hotel.Hotel.Services.HotelServices;
@Service
public class HotelServiceImpl implements HotelServices {

	@Autowired
	private HotelRepository hotelRepository;
	
	
	@Override
	public Hotel CreateHotel(Hotel hotel) {
		UUID uuid = UUID.randomUUID();
		String randomId=uuid.toString();
		hotel.setId(randomId);
		return hotelRepository.save(hotel);
	}

	@Override
	public Hotel getHotel(String hotelId) {
		
		return hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException());
	}

	@Override
	public List<Hotel> getAllHotelList() {
		
		return hotelRepository.findAll();
	}

}
