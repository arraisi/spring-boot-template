package com.oauth2.itsarraisi.oauth2.repository;

import com.oauth2.itsarraisi.oauth2.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
    Optional<User> findById(Integer id);
    Optional<User> findByEmail(String email);
    List<User> findAll();
}
