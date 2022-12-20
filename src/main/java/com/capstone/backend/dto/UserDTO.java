package com.capstone.backend.dto;

import com.capstone.backend.entity.Space;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {
    private long id;
    private String email;
    private String firstName;
    private String lastName;
    private UserDTO user;
    private List<Space> spaceList;

}
