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

    //TODO: Each user upon registration should be assigned a "unassigned space" where items that are not sorted into components or spaces can be placed OR unassigned spaces get an id of 0?
//TODO: Combine register and save into one. No need for both.
    @Override
    public User registerUser(User user){
        user.setPassword((bCryptPasswordEncoder.encode(user.getPassword())));
        return userRepository.save(user);
    }
    @Override
    public User saveUser(User user) {
        user.setPassword((bCryptPasswordEncoder.encode(user.getPassword())));
        return userRepository.save(user);
    }

//TODO: Make sure cascade type to delete all spaces, components, items associated with user.
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public void updatePassword(User userNewPass) {
        Long id = userNewPass.getId();
        User dbUser = getUser(id);
        dbUser.setPassword(userNewPass.getPassword());
       saveUser(dbUser);
    }

    @Override
    public User getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        return unwrapUser(user, id);
    }
//STRING GET USER IS NEEDED FOR AUTH PURPOSED
    @Override
    public User getUser(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return unwrapUser(user, email);
    }

// Method Returns the User Object with password field filled as "RESTRICTED"
//    FIXME: There has to be a better way to do this.
    @Override
    public User getUserProfile(Long id){
        return getUser(id);
    }
// Make sure this is working
    @Override
    public User updateUserProfile(Long id, User userProfile) {
        Optional<User> user = userRepository.findById(id);
        User unwrappedUser = unwrapUser(user, id);
        unwrappedUser.setFirstName(userProfile.getFirstName());
        unwrappedUser.setLastName(userProfile.getLastName());
        unwrappedUser.setEmail(userProfile.getEmail());
        return unwrappedUser;
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
