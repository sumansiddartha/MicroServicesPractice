package com.lcwd.user.UserService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.user.UserService.Entities.User;

public interface UserRepository extends JpaRepository<User, String>{

}
