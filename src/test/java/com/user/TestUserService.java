package com.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.user.dto.UserDetailsRequestDto;
import com.user.model.User;
import com.user.repository.UserRepository;
import com.user.service.UserServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
//@TestPropertySource("classpath:application-unittest.properties")
public class TestUserService {

	@InjectMocks
	private UserServiceImpl userServiceImpl;

	@MockBean
	private UserRepository userRepository;

	/**
	 * Success response 
	 */
	@Test
	@Tag("dev")
	void testGetUserDetailsbyName()  {
		UserDetailsRequestDto request = new UserDetailsRequestDto();
		request.setFirstName("swati");
		request.setLastName("Dhumal");
		
		User user = new User();
		user.setFirstName("Swati");
		user.setLastName("Dhumal");
		
		List<User> list = Arrays.asList(user);
		when(userRepository.findByFirstNameIgnoreCaseAndLastNameIgnoreCase(ArgumentMatchers.anyString(), ArgumentMatchers.anyString()))
				.thenReturn(list);
		assertEquals(list, userServiceImpl.getUserDetailsbyName(request));
	}
}
