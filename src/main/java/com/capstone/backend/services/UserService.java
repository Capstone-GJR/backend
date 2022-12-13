package com.capstone.backend.services;

import com.capstone.backend.entity.User;

import java.security.Principal;

public interface UserService {
    User getUser(Long id);
//    NEED THE STRING GET USER FOR AUTH PURPOSES
    User getUser(String email);
    User saveUser(User user);
    User registerUser(User user);
    void deleteUser(Long id);
    User updateUserProfile(Long id, User userProfile);
    void updatePassword(Principal user, String newPassword);
}
