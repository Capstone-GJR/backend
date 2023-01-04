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

    @Column
    private long value;

//    ToDo: Is this better as a string? Or a List<String> ... Which would be more easily searchable?
    @NonNull
    @NotBlank(message = "must include at least one keyword")
    private String keywords;

    @Column(columnDefinition = "varchar(255) default 'https://cdn.filestackcontent.com/PkMi3vJURiPIflMIycjK'")
    private String fileStackUrl;

    @Column
    private String color;


//    TODO: Is there a way to make this field optional instead of assigning it 0 if inside a space directly.
    @ManyToOne(optional = false)
    @JoinColumn(name = "tote_id", referencedColumnName = "id")
    private Tote tote;

}
