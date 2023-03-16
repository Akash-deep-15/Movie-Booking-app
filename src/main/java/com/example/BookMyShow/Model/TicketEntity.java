package com.example.BookMyShow.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity  // Annotation for creating a table
@Getter  // Annotation for getters
@Setter  // Annotation for setters
@NoArgsConstructor  // Annotation for default constructor
@AllArgsConstructor  // Annotation for all argument constructor
@Table(name = "tickets")  // Annotation for changing name
@Builder
public class TicketEntity {

    @Id  // Annotation of primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Annotation for Autoincrement
    private int id;

    @Column(name = "alloted_seats", nullable = false)
    private String allotedSeat;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "booked_at", nullable = false)
    private Date bookeadAt;

    @ManyToOne  // Annotation to determine relation
    @JoinColumn // Annotation for foreign key for default it will join i=on primary key
    @JsonIgnore // Annotation for ignoring in the request body
    UserEntity user;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    ShowEntity showEntity;

    @OneToMany (mappedBy = "ticketEntity", cascade = CascadeType.ALL)
    @JsonIgnore
    List<ShowSeatsEntity> showSeatsEntity;
}
