package com.lcwd.rating.RatingService.Services;

import java.util.List;

import com.lcwd.rating.RatingService.Entities.Rating;

public interface RatingService {
//Create Rating 
	public Rating Create(Rating rating);
//getAll Rating 
	public List<Rating> getRatings();
//getAll by UserId 

	public List<Rating> getRatingUserId(String userId);
	//getAll Hotel
	public List<Rating> getRatingHotelId(String hotelId);
}
