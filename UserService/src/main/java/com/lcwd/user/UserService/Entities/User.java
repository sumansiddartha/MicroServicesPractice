package com.lcwd.user.UserService.Entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Builder;

@Entity
@Table(name="UserTable")

public class User {
	@Id
	private String userId;
	private String name;
	private String email;
	private String about;
	@Transient
	private List<Rating> ratingList;

	public static class Builder{
		private String userId;
		private String name;
		private String email;
		private String about;
		@Transient
		private List<Rating> ratingList;
		
		
		public Builder() {
			super();
			
		}
		public Builder userId(String userId) {
			
			this.userId=userId;
			return this;
		}
		public Builder name(String name) {
			
			this.name=name;
			return this;
		}
		public Builder email(String email) {
			
			this.email=email;
			return this;
		}
		public Builder about(String about) {
			
			this.about=about;
			return this;
		}
		public Builder ratingList(List<Rating> ratingList) {
			
			this.ratingList=ratingList;
			return this;
		}
		
		
		public User build() {
			return new User(userId,name,email,about,ratingList);
		}
		
		
		
	}
	
	
	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public List<Rating> getRatingList() {
		return ratingList;
	}

	public void setRatingList(List<Rating> ratingList) {
		this.ratingList = ratingList;
	}

	public User(String userId, String name, String email, String about, List<Rating> ratingList) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.about = about;
		this.ratingList = ratingList;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
