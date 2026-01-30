package com.lcwd.hotel.Hotel.Controller;

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

import com.lcwd.hotel.Hotel.Entities.Hotel;
import com.lcwd.hotel.Hotel.Services.HotelServices;

@RestController
@RequestMapping(value="/hotel")
public class HotelController {

	@Autowired
	private HotelServices hotelService;
	
	
	
	@PreAuthorize("hasAuthority('Admin')")
	@PostMapping(value="/hotelCreate")
	public ResponseEntity<Hotel> hotelCreate(@RequestBody Hotel hotel){
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.CreateHotel(hotel));
		
	}
	
	
	@PreAuthorize("hasAuthority('SCOPE_internal')")
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotel(hotelId));
	}
	
	 @PreAuthorize("hasAuthority('SCOPE_internal')")
	@GetMapping("/getAllHotelList")
	public ResponseEntity<List<Hotel>> getAll(){
		return ResponseEntity.ok(hotelService.getAllHotelList());
	}
	
}
