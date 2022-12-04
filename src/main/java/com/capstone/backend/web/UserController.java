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

    //TODO: LOGOUT

    UserService userService;

//Returns a user object with RESTRICTED for a password.
    @GetMapping("/profile/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User profile = userService.getUserProfile(id);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<User> createUser(@Valid@RequestBody User user) {
        userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//TODO: UPDATE USER, what parms to pass?

    @PutMapping("/edit/{id}")
    public ResponseEntity<User> updateUser() {

        return new ResponseEntity<>(userService.updateUser(), HttpStatus.OK);
    }

//        @GetMapping("/{id}") // This method only returns the username. Not sure if this is useful or can be deleted.
//        public ResponseEntity<String> findById(@PathVariable Long id) {
//            String username = userService.getUser(id).getEmail();
//            return new ResponseEntity<>(username, HttpStatus.OK);
//        }

}
