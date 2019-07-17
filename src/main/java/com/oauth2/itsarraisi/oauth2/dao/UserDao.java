package com.oauth2.itsarraisi.oauth2.dao;

import com.oauth2.itsarraisi.oauth2.entity.User;
import com.oauth2.itsarraisi.oauth2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDao {
    @Autowired
    UserRepository repository;

    public Optional<User> findById(Integer id){
        return repository.findById(id);
    }
}
