package com.genericAPI.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.genericAPI.models.UserModel;
import com.genericAPI.repository.UserRepository;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/people")
public class UserController {
    private UserRepository userRepository;

    public UserController (UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping()
    public ResponseEntity<UserModel> post(@RequestBody @Valid UserModel userEntity) {
       
        return ResponseEntity.ok( userRepository.save(userEntity));
    }

    @GetMapping()
    public ResponseEntity<List<UserModel>> getAll() {
        List<UserModel> response = userRepository.findAll();
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@RequestParam UUID id) {
        Optional<UserModel> response = userRepository.findById(id);
        return ResponseEntity.ok(response);
    }
    
}
