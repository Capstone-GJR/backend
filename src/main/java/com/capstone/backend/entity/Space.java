package com.capstone.backend.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "spaces")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Space {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @NotBlank(message = "space name cannot be blank")
    @Column(nullable = false)
    private String name;

//    TODO: Should this be an optional field? AKA nullable = true? or how do I do this.
    @Column(nullable = false)
    private String description;

//    ToDo: Is this better as a string? Or a List<String> ... Which would be more easily searchable?
    @NonNull
    @NotBlank(message = "must include at least one keyword")
    private String keywords;

//    Default color value - So that we have a fallback if user does not want to upload an img and also if issue retrieving img.
    @NonNull
    @Column(nullable = false)
    private String fileStackImgURL;

//    ToDo: Define a set of colors that this can be... Or potentially pass in hex-code? and "space" is constant with that space hex-code value?
    @NonNull
    @Column(nullable = false)
    private String color;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


}
