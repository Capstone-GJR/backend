package com.capstone.backend.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
//TODO: default values for fields.
@Entity
@Table(name = "items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private long value;

//    ToDo: Is this better as a string? Or a List<String> ... Which would be more easily searchable?
    @NonNull
    @NotBlank(message = "must include at least one keyword")
    private String keywords;

    @Column(nullable = false)
    private String fileStackUrl;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    boolean checkedOut;

    @ManyToOne(optional = false)
    @JoinColumn(name = "space_id", referencedColumnName = "id")
    private Space space;

//    TODO: Is there a way to make this field optional instead of assigning it 0 if inside a space directly.
// Enter component id of 0 if this item is inside a space directly.
    @ManyToOne(optional = true)
    @JoinColumn(name = "component_id", referencedColumnName = "id")
    private Component component;

}
