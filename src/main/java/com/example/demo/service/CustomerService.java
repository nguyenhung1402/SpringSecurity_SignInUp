package com.example.demo.service;

import com.example.demo.CustomerRepo.CustomerRepo;
import com.example.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    CustomerRepo customerRepo;

    public Customer createCustomer(Customer customer){
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));

         return customerRepo.save(customer);

    }
}
