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

public class User {
//Constructor for user Profile
//    FIXME: Confirm that this is the best way to do this. Should I be creating an object that exists without the password at all instead?
    public User(long id, @NonNull String email, @NonNull String firstName, @NonNull String lastName) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
//        this.unassigned = unassigned;
        this.password = "RESTRICTED";
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
