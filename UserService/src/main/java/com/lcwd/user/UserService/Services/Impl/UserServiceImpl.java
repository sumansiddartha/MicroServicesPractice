package com.lcwd.user.UserService.Services.Impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lcwd.user.UserService.Entities.Hotel;
import com.lcwd.user.UserService.Entities.Rating;
import com.lcwd.user.UserService.Entities.User;
import com.lcwd.user.UserService.Exception.ResourceNotFoundException;
import com.lcwd.user.UserService.External.Services.HotelService;
import com.lcwd.user.UserService.Repository.UserRepository;
import com.lcwd.user.UserService.Services.UserService;




@Service
public class UserServiceImpl implements UserService {
private Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@Autowired
	private HotelService hotelService;
	
	
	@Override
	public User SaveUser(User user) {
		UUID uuid = UUID.randomUUID();
		String randomId=uuid.toString();
		user.setUserId(randomId);
		
		 return userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User getUser(String userId) {
		User user = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException());
		Rating[] UserRatingArray = restTemplate.getForObject("http://RATINGSERVICE/rating/user/"+user.getUserId(), Rating[].class);
		
		List<Rating> ratings=Arrays.stream(UserRatingArray).toList();
		 
		 List<Rating> ratingList=ratings.stream().map(rating->{
				//api call to hotel service and get hotel for rest
//				 ResponseEntity<Hotel> hotelResponse = restTemplate.getForEntity("http://HOTEL/hotel/"+rating.getHotelId(), Hotel.class);
//			 Api using feign client
//				 Hotel hotel = hotelResponse.getBody();
				 Hotel hotel = hotelService.getHotel(rating.getHotelId());
				 rating.setHotel(hotel);
//				 logger.info("Status code : {}",hotelResponse.getStatusCode());
				 return rating;
			 }).collect(Collectors.toList());	
		 user.setRatingList(ratingList);
		 logger.info("{} ",ratingList);
		return user;
	}

}
