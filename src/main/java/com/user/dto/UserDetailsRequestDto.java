package com.user.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDetailsRequestDto {
	@NotEmpty(message = "firstName should not be empty")
	private String firstName;
	@NotEmpty(message = "lastName should not be empty")
	private String lastName;

	private Long userId;

}
