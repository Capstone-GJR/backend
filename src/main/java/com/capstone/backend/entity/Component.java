package com.capstone.backend.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "components")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor

public class Component {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
