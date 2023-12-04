package com.user.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.dto.UpdateUserRequestDto;
import com.user.dto.UserDetailsRequestDto;
import com.user.service.UserService;

import jakarta.validation.Valid;
import lombok.extern.java.Log;

@RestController
@RequestMapping("/api/user")
@Log
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("getAllUsers")
	public ResponseEntity<Object> getAllUsers(@RequestHeader("Authorization") String authorizationHeader) {
		Map<String, Object> response = new LinkedHashMap<>();
		try {
			response.put("data", userService.getAllUsers());
			return ResponseEntity.status(200).body(response);
		} catch (Exception e) {
			log.warning(e.getMessage());
			response.put("status", 500);
			response.put("message", e.getMessage());
			return ResponseEntity.status(500).body(response);
		}
	}

	@GetMapping("getUsersByName")
	public ResponseEntity<Object> getUsersByName(@RequestBody @Valid UserDetailsRequestDto userDetailsRequestDto,
			@RequestHeader("Authorization") String authorizationHeader) {
		Map<String, Object> response = new LinkedHashMap<>();
		try {
			response.put("data", userService.getUserDetailsbyName(userDetailsRequestDto));
			return ResponseEntity.status(200).body(response);
		} catch (Exception e) {
			log.warning(e.getMessage());
			response.put("status", 500);
			response.put("message", e.getMessage());
			return ResponseEntity.status(500).body(response);
		}
	}

	@PostMapping("updateUser")
	public ResponseEntity<Object> updateUser(@RequestBody @Valid UpdateUserRequestDto updateUserRequestDto,
			@RequestHeader("Authorization") String authorizationHeader) {
		Map<String, Object> response = new LinkedHashMap<>();
		try {
			userService.updateUser(updateUserRequestDto);
			response.put("data", "User updated Successfully");
			return ResponseEntity.status(200).body(response);
		} catch (Exception e) {
			log.warning(e.getMessage());
			response.put("status", 500);
			response.put("message", e.getMessage());
			return ResponseEntity.status(500).body(response);
		}
	}

}
