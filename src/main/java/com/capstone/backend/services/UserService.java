package com.capstone.backend.services;

import com.capstone.backend.entity.User;

public interface UserService {
    User getUser(Long id);
    User getUserProfile(Long id);
//    NEED THE STRING GET USER FOR AUTH PURPOSES
    User getUser(String email);
    User saveUser(User user);
    User registerUser(User user);
    void deleteUser(Long id);
    User updateUserProfile(Long id, String firstName, String lastName, String email);

}
