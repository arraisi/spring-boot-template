package com.oauth2.itsarraisi.oauth2.service;

import com.oauth2.itsarraisi.oauth2.entity.CustomUserDetails;
import com.oauth2.itsarraisi.oauth2.entity.User;
import com.oauth2.itsarraisi.oauth2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> optionalUser = repository.findByEmail(email);

        optionalUser.orElseThrow(() -> new UsernameNotFoundException("Email not found"));
        return optionalUser.map(user -> new CustomUserDetails(user)).get();
    }
}
