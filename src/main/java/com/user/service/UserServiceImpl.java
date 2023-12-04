package com.user.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.user.dto.UpdateUserRequestDto;
import com.user.dto.UserDetailsRequestDto;
import com.user.model.Address;
import com.user.model.User;
import com.user.repository.UserRepository;

import lombok.extern.java.Log;

@Service
@Transactional
@Log
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	public List<User> getUserDetailsbyName(UserDetailsRequestDto request) {
		return userRepository.findByFirstNameIgnoreCaseAndLastNameIgnoreCase(request.getFirstName(),
				request.getLastName());
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public void updateUser(UpdateUserRequestDto updateUserRequestDto) {
		if (updateUserRequestDto != null) {
			var userData = userRepository.findById(updateUserRequestDto.getUserId()).orElseThrow(
					() -> new RuntimeException("User not found with ID: " + updateUserRequestDto.getUserId()));

			userData.setFirstName(
					StringUtils.isNotBlank(updateUserRequestDto.getFirstName()) ? updateUserRequestDto.getFirstName()
							: userData.getFirstName());
			userData.setLastName(
					StringUtils.isNotBlank(updateUserRequestDto.getLastName()) ? updateUserRequestDto.getLastName()
							: userData.getLastName());
			userData.setTitle(StringUtils.isNotBlank(updateUserRequestDto.getTitle()) ? updateUserRequestDto.getTitle()
					: userData.getTitle());
			userData.setGender(
					StringUtils.isNotBlank(updateUserRequestDto.getGender()) ? updateUserRequestDto.getGender()
							: userData.getGender());
			userData.setEmployeeId(
					StringUtils.isNotBlank(updateUserRequestDto.getEmployeeId()) ? updateUserRequestDto.getEmployeeId()
							: userData.getEmployeeId());
			List<Address> updatedAddresses = updateUserRequestDto.getCustomerAddresses();
			userData.getCustomerAddresses().clear(); // Remove existing addresses
			if (updatedAddresses != null) {
	            updatedAddresses.forEach(address -> {
	                address.setUser(userData);
	                userData.getCustomerAddresses().add(address);
	            });
	        }

			userRepository.save(userData);
		}
	}

}
