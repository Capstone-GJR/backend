package com.capstone.backend.entity;

import lombok.*;

import javax.persistence.*;

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

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false, columnDefinition = "boolean default false")
    boolean checkedOut;

    @ManyToOne(optional = false)
    @JoinColumn(name = "space_id", referencedColumnName = "id")
    private Space Space;

//    in order to access all components by a user you would need to find... spaces owned by user - then all components that match those space ids
}
