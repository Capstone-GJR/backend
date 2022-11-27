package com.capstone.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Username cannot be blank")
    @NonNull
    @Column(nullable = false)
    String username;

    @NotBlank(message = "Password cannot be blank")
    @NonNull
    @Column(nullable = false)
    String password;


}
