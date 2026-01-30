package com.lcwd.rating.RatingService.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.rating.RatingService.Entities.Rating;
import com.lcwd.rating.RatingService.Repository.RatingRepository;
import com.lcwd.rating.RatingService.Services.RatingService;


@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
private RatingRepository ratingRepo;
	
	
	@Override
	public Rating Create(Rating rating) {
		// TODO Auto-generated method stub
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getRatings() {
		
		return ratingRepo.findAll();
	}

	@Override
	public List<Rating> getRatingUserId(String userId) {
		// TODO Auto-generated method stub
		return ratingRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingHotelId(String hotelId) {
		// TODO Auto-generated method stub
		return ratingRepo.findByHotelId(hotelId);
	}

}
