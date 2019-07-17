package com.oauth2.itsarraisi.oauth2.controller;

import com.oauth2.itsarraisi.oauth2.entity.User;
import com.oauth2.itsarraisi.oauth2.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApi {
    @Autowired
    UserService service;

    @PostMapping("/")
    public ResponseEntity<User> registration(@RequestBody User param){
        User user = service.save(param);
      return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> findById(@PathVariable Integer id){
        Optional<User> user = service.findById(id);
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }
}
