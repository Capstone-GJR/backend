package com.capstone.backend.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "components")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Component {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Components must have names")
    @NonNull
    @Column(nullable = false)
    private String name;

//    ToDo: Is this better as a string? Or a List<String> ... Which would be more easily searchable?
    @NonNull
    @NotBlank(message = "must include at least one keyword")
    private String keywords;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private String fileStackUrl;

    @Column(nullable = false)
    boolean checkedOut;

    @ManyToOne(optional = false)
    @JoinColumn(name = "space_id", referencedColumnName = "id")
    private Space space;

//    Parent id = 0 if component is directly inside a space, Parent id = component_id, when the component is inside another component.
    @NonNull
    @Column(nullable = false)
    private long parent_id;

}
