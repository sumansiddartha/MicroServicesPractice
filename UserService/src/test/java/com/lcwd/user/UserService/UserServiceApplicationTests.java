package com.lcwd.user.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lcwd.user.UserService.Entities.Rating;
import com.lcwd.user.UserService.External.Services.RatingService;

@SpringBootTest
class UserServiceApplicationTests {

	@Autowired
	private RatingService ratingService;
	
	
//	@Test
//	void contextLoads() {
//	}
//	@Test
//	void createRating() {
//		Rating rating=new 	Rating.Builder().rating(10).userId("lkjasfjd;ljd").hotelId(null).feedback("This is a nice hotel").build();
//		Rating createRating = ratingService.CreateRating(rating);
//		System.out.println("=====new rating created====");
//	}
	
	

}
