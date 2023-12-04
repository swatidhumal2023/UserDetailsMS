package com.user.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.user.model.Address;
import com.user.model.User;
import com.user.repository.UserRepository;

@Component
public class UserDataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    
    @Override
    public void run(String... args) throws Exception {
        insertSampleData();
    }

    private void insertSampleData() {
        // Create users
        User user1 = new User(Long.valueOf("1"), "Miss", "Swati", "Dhumal", "F", "emp1");
        User user2 = new User(Long.valueOf("2"), "Mr", "Martin", "Smith", "M", "emp2");
       
        // Create addresses
        Address address1 = new Address(Long.valueOf("1"), "Wingrove Avenue", "Epping", "NSW", Long.valueOf("2121"), user1 );
        Address address2 = new Address(Long.valueOf("2"), "Pitt Street", "Redfern", "NSW", Long.valueOf("2152"), user2 );
             
        // Associate addresses with users
                     
        var custAddresses2 = new ArrayList<Address>();
        custAddresses2.add(address2);       
        
        user1.setCustomerAddresses(List.of(address1));
        user2.setCustomerAddresses(custAddresses2);     
      
        // Save users to the database
        userRepository.saveAll(List.of(user1, user2));
    }
}