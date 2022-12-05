package com.capstone.backend.web;

import com.capstone.backend.dto.UserDTO;
import com.capstone.backend.entity.User;
import com.capstone.backend.services.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
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

    ModelMapper modelMapper;
    UserService userService;

    @GetMapping("/profile/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        User profile = userService.getUserProfile(id);
        UserDTO userProfileDTO = modelMapper.map(profile, UserDTO.class);
        return new ResponseEntity<>(userProfileDTO, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<User> createUser(@Valid@RequestBody User user) {
        userService.saveUser(user);
//TODO:  Space unassignedSpace = new Space(""); // pass in newUser id when you create a newSpace
//        save space with space service
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//TODO: UPDATE USER: How to get User object to be sent back without the password field, OR just send back an OK status. No need to send them the User right?

    @PutMapping("/edit/{id}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody User user, @PathVariable Long id) {
        UserDTO updatedProfile = modelMapper.map((userService.updateUserProfile(id,user)), UserDTO.class);
        return new ResponseEntity<>(updatedProfile, HttpStatus.OK);
    }

    @PutMapping("/editPW")
    public ResponseEntity<User> updatePassword(@RequestBody User userNewPass) {
        userService.updatePassword(userNewPass);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
