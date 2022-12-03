package com.capstone.backend.web;

import com.capstone.backend.entity.User;
import com.capstone.backend.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class UserController {

    UserService userService;

//    @GetMapping("/{id}") // functioning method - method below is experimental method
//    public ResponseEntity<String> findById(@PathVariable Long id) {
//        String username = userService.getUser(id).getEmail();
//        return new ResponseEntity<>(username, HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<String> findById(@PathVariable Long id) {
        String username = userService.getUser(id).getEmail();
        //        TODO: update the response entity to include all information needed for the profile page.
        return new ResponseEntity<>(username, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<User> createUser(@Valid@RequestBody User user) {
        userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
