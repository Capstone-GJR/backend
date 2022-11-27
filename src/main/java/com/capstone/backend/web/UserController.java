package com.capstone.backend.web;

import com.capstone.backend.entity.User;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/{id}")
    public ResponseEntity<String> findById(@PathVariable Long id) {
        return null;
    }

    @GetMapping("/register")
    public ResponseEntity<User> createUser(@Valid@RequestBody User user) {
        return null;
    }
}
