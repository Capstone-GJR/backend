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

public class User {
    public User() {
        this.unassigned = new Space();
    }

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

    @Transient
    private Space unassigned;
}
