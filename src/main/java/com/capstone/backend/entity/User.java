package com.capstone.backend.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

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

    @NotBlank
    @NonNull
    @Column(nullable = false)
    private String firstName;

    @NotBlank
    @NonNull
    @Column(nullable = false)
    private String lastName;

//    todo: Each user upon registration should be assigned a "unassigned space" where items that are not sorted into components or spaces can be placed.
    @Transient
    private Space unassigned;
}
