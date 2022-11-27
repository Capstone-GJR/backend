package com.capstone.backend.services;

import com.capstone.backend.entity.User;

public interface UserService {
    User getUser(Long id);
    User getUser(String username);
    User saveUser(User user);

}
