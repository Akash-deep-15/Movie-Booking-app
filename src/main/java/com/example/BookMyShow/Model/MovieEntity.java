package com.example.BookMyShow.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="movies")
@Builder
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="release_date", columnDefinition = "Date", nullable = false)
    private LocalDate releaseDate;

    @OneToMany (mappedBy = "movieEntity", cascade = CascadeType.ALL)
    @JsonIgnore
    List<ShowEntity> showEntity;
}
