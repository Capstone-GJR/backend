package com.capstone.backend.entity;

import lombok.*;

import javax.persistence.*;

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
    private String description;

    @Column(nullable = false, columnDefinition = "boolean default false")
    boolean checkedOut;

    @ManyToOne(optional = false)
    @JoinColumn(name = "space_id", referencedColumnName = "id")
    private Space Space;

    @ManyToOne(optional = false)
    @JoinColumn(name = "component_id", referencedColumnName = "id")
    private Component component;
}
