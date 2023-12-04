package com.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByFirstNameIgnoreCaseAndLastNameIgnoreCase(String firstname, String lastName);
	
	List<User> findAll();
}