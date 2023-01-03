package com.capstone.backend.web;

import com.capstone.backend.dto.UserDTO;
import com.capstone.backend.entity.Space;
import com.capstone.backend.entity.User;
import com.capstone.backend.exception.EmailExistsException;
import com.capstone.backend.services.SpaceService;
import com.capstone.backend.services.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class UserController {

//TODO: LOGOUT

    ModelMapper modelMapper;
    UserService userService;
    SpaceService spaceService;

//Grabs the user information based on the authenticated user so no need to use the id in the path to get user profile
    @GetMapping("/")
    public UserDTO user(Principal user) {
        User fullUser = userService.getUser(user.getName());
        return modelMapper.map(fullUser, UserDTO.class);
    }

    @PostMapping("/register")
    public ResponseEntity<User> createUser(@Valid@RequestBody User user) throws EmailExistsException {
        userService.checkEmailExists (user.getEmail());
        Space unassigned = new Space();
        unassigned.setName("unassigned");
        unassigned.setKeywords("unassigned");
        userService.saveUser(user);
        spaceService.saveSpace(unassigned, user.getId());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/edit/")
    public ResponseEntity<UserDTO> updateUser(@RequestBody User user, Principal userID) {
        Long id = userService.getUser(userID.getName()).getId();
        UserDTO updatedProfile = modelMapper.map((userService.updateUserProfile(id,user)), UserDTO.class);
        return new ResponseEntity<>(updatedProfile, HttpStatus.OK);
    }

    @PutMapping("/editPW")
    public ResponseEntity<User> updatePassword(@RequestBody User newPass, Principal user) {
        String newPassword = newPass.getPassword();
        userService.updatePassword(user, newPassword);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
