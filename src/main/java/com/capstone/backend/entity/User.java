package com.capstone.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "email cannot be blank")
    @NonNull
    @Email
    @Column(nullable = false)
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @NonNull
    @Column(nullable = false)
    private String password;

    @NotBlank(message = "Must enter a first name")
    @NonNull
    @Column(nullable = false)
    private String firstName;

    @NotBlank(message = "Must enter a last name")
    @NonNull
    @Column(nullable = false)
    private String lastName;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Space> spaces;

//TODO: Each user upon registration should be assigned a "unassigned space" where items that are not sorted into components or spaces can be placed.
//      OR unassigned spaces get an id of 0?
    @Transient
    private Space unassigned;


}
