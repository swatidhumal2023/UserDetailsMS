package com.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.user.controller.UserController;
import com.user.model.User;
import com.user.service.UserService;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)//, properties = "spring.profiles.active=local")
@AutoConfigureWebMvc
//@TestPropertySource("classpath:application-local.properties")
@ExtendWith(MockitoExtension.class)
class TestUserController {
	private static final Logger LOG = Logger.getLogger(TestUserController.class.getName());

	@MockBean(name = "restTemplate")
	private RestTemplate restTemplate;

	private MockMvc mvc;
	
	@Autowired
	@InjectMocks
	private UserController userController;

	@MockBean
	private UserService userService;

	@Autowired
	private WebApplicationContext context;

	@BeforeEach
	void setUp() throws Exception {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	@Tag("dev")
	void testGetAllUsers() throws Exception {
		LOG.info("=================TestUserController#testGetAllUsers() MS#  Test cases running==========");
		var user = new ArrayList<User>();
		when(userService.getAllUsers())
				.thenReturn(user);
		ResponseEntity<Object> response = userController.getAllUsers(null);
		assertEquals(HttpStatus.OK, response.getStatusCode());		
		assertNotNull(response.getBody());		
		LOG.info("=================TestUserController#testGetAllUsers() MS#  Test cases ends==========");
	}	
}