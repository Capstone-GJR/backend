package com.capstone.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

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
    private String tags;

    // Nullable = optional field. if no image color with display instead.
    @Column(columnDefinition = "varchar(255) default 'https://cdn.filestackcontent.com/PkMi3vJURiPIflMIycjK'")
    private String fileStackUrl;

    //ToDo: Define a set of colors that this can be... Or potentially pass in hex-code? and "space" is constant with that space hex-code value? Change default value to a hex-code? get with guys on this.
    @Column
    private String color = "space";

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnoreProperties("password")
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "space", cascade = CascadeType.ALL)
    private List<Tote> totes;

    @Override
    public String toString() {
        return "Space{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tags='" + tags + '\'' +
                ", fileStackUrl='" + fileStackUrl + '\'' +
                ", color='" + color + '\'' +
                ", user=" + user +
                '}';
    }
}
