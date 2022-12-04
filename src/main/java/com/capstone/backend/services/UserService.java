package com.capstone.backend.services;

import com.capstone.backend.entity.User;

public interface UserService {
    User getUser(Long id);

    // TODO: Here is where I should specify how I want the user profile to be returned. Maybe make a field that is "user profile" - a copy of the user copy without the password?
    User getUserProfile(Long id);
    User getUser(String email);
    User saveUser(User user);

}
