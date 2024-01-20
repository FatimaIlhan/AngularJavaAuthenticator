package com.springsecurityjwt.service;

import com.springsecurityjwt.modal.User;
import com.springsecurityjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class CustomUserDetailsService implements UserDetailsService {
    //inject repository to communicate with db
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { //This method is part of the UserDetailsService interface provided by Spring Security. It is used to load a user by their username during the authentication process.

     User user = userRepository.findByUserName(username);//This line fetches a User entity from the database using the injected UserRepository
        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),new ArrayList<>());//This line creates and returns a UserDetails object. The UserDetails is an interface in Spring Security that represents core user information. In this case, it's using an implementation provided by Spring Security

    }
}
