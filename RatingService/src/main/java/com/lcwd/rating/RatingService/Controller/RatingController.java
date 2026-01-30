package com.lcwd.rating.RatingService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.rating.RatingService.Entities.Rating;
import com.lcwd.rating.RatingService.Services.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@PostMapping("/CreateRating")
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<Rating> CreateRating(@RequestBody Rating rating){
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.Create(rating));
	}
	@GetMapping("/getAllRatings")
	@PreAuthorize("hasAuthority('SCOPE_internal')")
	public ResponseEntity<List<Rating>> RatingAll(){
		return ResponseEntity.ok(ratingService.getRatings());
	}
	@GetMapping("/hotel/{hotelId}")
	@PreAuthorize("hasAuthority('SCOPE_internal')")
	public ResponseEntity<List<Rating>> RatingByHotelId(@PathVariable String hotelId){
		return ResponseEntity.ok(ratingService.getRatingHotelId(hotelId));
	}
	@GetMapping("/user/{userId}")
	@PreAuthorize("hasAuthority('SCOPE_internal')||hasAuthority('Admin')")
	public ResponseEntity<List<Rating>> RatingByUserId(@PathVariable String userId){
		return ResponseEntity.ok(ratingService.getRatingUserId(userId));
	}
}
