package com.lcwd.user.UserService.External.Services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.lcwd.user.UserService.Entities.Rating;

@FeignClient(name="RATINGSERVICE")
@Service
public interface RatingService {

	
	@PostMapping(value="/rating/CreateRating")
	public Rating CreateRating(Rating values);
	
	@PutMapping(value="/rating/{ratingId}")
	public Rating UpdateRating(@PathVariable String ratingId,Rating rating);
	
	@DeleteMapping(value="/rating/{ratingId}")
	public Rating DeleteRating(@PathVariable String ratingId);
}
