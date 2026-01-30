package com.lcwd.hotel.Hotel.Services;

import java.util.List;

import com.lcwd.hotel.Hotel.Entities.Hotel;

public interface HotelServices {
	
	
	public Hotel CreateHotel(Hotel hotel);
	public Hotel getHotel(String hotelId);
	
	public List<Hotel> getAllHotelList();

}
