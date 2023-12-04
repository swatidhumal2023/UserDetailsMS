package com.user.dto;

import java.util.List;

import com.user.model.Address;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateUserRequestDto {	
	@Positive(message = "User ID must be a positive number")
	private Long userId;
	private String firstName;	
	private String lastName;
	private String title;
	private String gender;
	private String employeeId;		
	List<Address> customerAddresses;
	
}
