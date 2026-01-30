package com.lcwd.user.UserService.Entities;

public class Rating {
private String ratingId;
private String userId;
private String hotelId;
private int rating;
private String feedback;
private Hotel hotel;



//Builder class as a static nested class
public static class Builder {
    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;
    private Hotel hotel;

    public Builder() {
		super();
		
	}

	public Builder ratingId(String ratingId) {
        this.ratingId = ratingId;
        return this;
    }

    public Builder userId(String userId) {
        this.userId = userId;
        return this;
    }

    public Builder hotelId(String hotelId) {
        this.hotelId = hotelId;
        return this;
    }

    public Builder rating(int rating) {
        this.rating = rating;
        return this;
    }

    public Builder feedback(String feedback) {
        this.feedback = feedback;
        return this;
    }

    public Builder hotel(Hotel hotel) {
        this.hotel = hotel;
        return this;
    }

    public Rating build() {
        return new Rating(ratingId, userId, hotelId, rating, feedback, hotel);
    }
}



//getters and setters
public String getRatingId() {
	return ratingId;
}
public void setRatingId(String ratingId) {
	this.ratingId = ratingId;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getHotelId() {
	return hotelId;
}
public void setHotelId(String hotelId) {
	this.hotelId = hotelId;
}
public int getRating() {
	return rating;
}
public void setRating(int rating) {
	this.rating = rating;
}
public String getFeedback() {
	return feedback;
}
public void setFeedback(String feedback) {
	this.feedback = feedback;
}


public Hotel getHotel() {
	return hotel;
}
public void setHotel(Hotel hotel) {
	this.hotel = hotel;
}
//Constructor all args
public Rating(String ratingId, String userId, String hotelId, int rating, String feedback,Hotel hotel) {
	super();
	this.ratingId = ratingId;
	this.userId = userId;
	this.hotelId = hotelId;
	this.rating = rating;
	this.feedback = feedback;
	this.hotel=hotel;
}
//Constructor no-args
public Rating() {
	super();
	
}



}
