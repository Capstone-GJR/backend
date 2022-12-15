package com.capstone.backend.repository;

import com.capstone.backend.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
//    Optional<User> findByEmail(String email);
    User findByEmail(String email);
}
