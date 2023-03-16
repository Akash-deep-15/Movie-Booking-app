package com.example.BookMyShow.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity  // Annotation for creating a table
@Getter  // Annotation for getters
@Setter  // Annotation for setters
@NoArgsConstructor  // Annotation for default constructor
@AllArgsConstructor  // Annotation for all argument constructor
@Table(name = "users")  // Annotation for changing name
@Builder
public class UserEntity {

    @Id  // Annotation for primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Annotation for auto incrementing
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "mobile", nullable = false)
    private String mobile;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) // Annotation for relation when deleted it will delete all contents related to it
    @JsonIgnore
    List<TicketEntity> tickets;
}
