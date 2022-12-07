package com.capstone.backend;

import com.capstone.backend.entity.User;
import com.capstone.backend.repository.UserRepository;
import com.capstone.backend.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void getUserFromRepoTest() {
        when(userService.getUser(1L))
                .thenReturn(new User(1L,"TaraDactyl@dino.com","$2a$10$wEc65/etNcCBKYLzlHTvvOILPkbi9DyFnIHaLRK8HO7vMArTZJIn2","Tara","Dactyl"));
        User result = userService.getUser(1L);

        assertEquals("Tara", result.getFirstName());
        assertEquals("Dactyl", result.getLastName());
        assertEquals("$2a$10$wEc65/etNcCBKYLzlHTvvOILPkbi9DyFnIHaLRK8HO7vMArTZJIn2", result.getPassword());
        assertEquals(1L, result.getId());
        assertEquals("TaraDactyl@dino.com", result.getEmail());

    }

}
