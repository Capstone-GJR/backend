package com.capstone.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
//    private List<Space> spaceList;

}
