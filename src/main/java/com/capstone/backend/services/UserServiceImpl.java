package com.capstone.backend.services;

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

    //TODO: Each user upon registration should be assigned a "unassigned space" where items that are not sorted into components or spaces can be placed.
    //      OR unassigned spaces get an id of 0?
    @Override
    public User registerUser(User user){
        user.setPassword((bCryptPasswordEncoder.encode(user.getPassword())));
        return userRepository.save(user);
    }

//TODO: Make sure cascade type to delete all spaces, components, items associated with user.
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

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
        return userRepository.save(user);
    }

// Method Returns the User Object with password field filled as "RESTRICTED"
    @Override
    public User getUserProfile(Long id){
        User user = getUser(id);
        return new User(user.getId(), user.getEmail(), user.getFirstName(), user.getLastName());
    }

//TODO: Update user logic.
    @Override
    public User updateUser() {
       return null;
    }

    static User unwrapUser(Optional<User> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new EntityNotFoundException(id, User.class);
    }

    static User unwrapUser(Optional<User> entity, String email) {
        if (entity.isPresent()) return entity.get();
        else throw new EntityNotFoundException(email, User.class);
    }
}
