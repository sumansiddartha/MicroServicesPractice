package com.lcwd.user.UserService.External.Services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lcwd.user.UserService.Entities.Hotel;

@FeignClient(name="HOTEL")
//@FeignClient(url="http:/localhost:8087",value="hotel-service")
public interface HotelService {
	
	@GetMapping(value="/hotel/{hotelId}")
	public Hotel getHotel(@PathVariable String hotelId);

}
