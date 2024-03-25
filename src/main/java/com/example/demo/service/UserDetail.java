package com.example.demo.service;

import com.example.demo.CustomerRepo.CustomerRepo;
import com.example.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetail implements UserDetailsService {
    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Customer> customers = customerRepo.findByUsername(username);
        String password=null;
        List<GrantedAuthority> authorities=null;
        if(customers.isEmpty()){
            throw new UsernameNotFoundException("Khong tim thay nguoi dung"+username);
        }

        username=customers.get(0).getUsername();
        password=customers.get(0).getPassword();
        authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(customers.get(0).getRole()));

        return new User(username,password,authorities);
    }
}
