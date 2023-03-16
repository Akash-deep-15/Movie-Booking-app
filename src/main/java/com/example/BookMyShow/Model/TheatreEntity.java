package com.example.BookMyShow.Model;

import com.example.BookMyShow.enums.TheatreType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "theaters")
@Builder
public class TheatreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name ="city", nullable = false)
    private String city;
    @Column(name ="address", nullable = false)
    private String address;

    TheatreType theatreType;

    @OneToMany (cascade = CascadeType.ALL)  // make the relationships bidirectional
    @JsonIgnore
    List<ShowEntity> shows;

    @OneToMany (mappedBy = "theatreEntity", cascade = CascadeType.ALL)  // make the relationships bidirectional
    @JsonIgnore
    List<TheatreSeatEntity> seats;
}
