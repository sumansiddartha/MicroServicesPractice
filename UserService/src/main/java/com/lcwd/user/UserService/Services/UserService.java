package com.lcwd.user.UserService.Services;

import java.util.List;

import com.lcwd.user.UserService.Entities.User;

public interface UserService {

	User SaveUser(User user);
	
	//get all users
	List<User> getAllUser();
	//get Single user from given userId
	User getUser(String userId);
	
}
