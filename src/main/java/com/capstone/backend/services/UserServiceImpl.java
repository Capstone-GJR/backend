package com.capstone.backend.services;

import com.capstone.backend.entity.Space;
import com.capstone.backend.entity.User;
import com.capstone.backend.exception.EntityNotFoundException;
import com.capstone.backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public User getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        return unwrapUser(user, id);
    }

    @Override
    public User getUser(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return unwrapUser(user, email);
    }

    @Override
    public User saveUser(User user) {
        user.setPassword((bCryptPasswordEncoder.encode(user.getPassword())));
        user.setUnassigned(new Space());
        return userRepository.save(user);
    }

    static User unwrapUser(Optional<User> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new EntityNotFoundException(id, User.class);
    }

    static User unwrapUser(Optional<User> entity, String email) {
        if (entity.isPresent()) return entity.get();
        else throw new EntityNotFoundException(email, User.class);
    }
    // TODO: Here is where I should specify how I want the user profile to be returned. Maybe make a field that is "user profile" - a copy of the user copy without the password?
    public User getUserProfile(Long id){
        User user = getUser(id);
        User profile = new User(user.getId(), user.getEmail(), user.getFirstName(), user.getLastName(), user.getUnassigned());
        return profile;
    }
}
