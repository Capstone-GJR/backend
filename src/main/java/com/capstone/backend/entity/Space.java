package com.capstone.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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


//ToDo: Make this a List<String> ... Which would be more easily searchable?
    @NonNull
    @NotBlank(message = "must include at least one keyword")
    private String keywords;

// Nullable = optional field. if no image color with display instead.
    @Column(name = "fileStackUrl", nullable = true)
    private String fileStackUrl;

//ToDo: Define a set of colors that this can be... Or potentially pass in hex-code? and "space" is constant with that space hex-code value? Change default value to a hex-code? get with guys on this.
    @NonNull
    @Column(nullable = false, columnDefinition = "varchar(255) default 'space'")
    private String color;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnoreProperties("password")
    private User user;


}
