package com.user.service;

import java.util.List;

import com.user.dto.UpdateUserRequestDto;
import com.user.dto.UserDetailsRequestDto;
import com.user.model.User;

public interface UserService {		

	 List<User> getUserDetailsbyName(UserDetailsRequestDto request) ;
	 
	 List<User> getAllUsers() ;	
	 
	 void updateUser(UpdateUserRequestDto updateUserRequestDto);
}