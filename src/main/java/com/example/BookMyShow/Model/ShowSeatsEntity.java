package com.example.BookMyShow.Model;

import com.example.BookMyShow.enums.SeatType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="show_seats")
@Builder
public class ShowSeatsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int rate;
    private String seatNumber;
    private SeatType seatType;
    private boolean booked;
    private Date bookedAt;

    @ManyToOne
    @JsonIgnore
    TicketEntity ticketEntity;

    @ManyToOne
    @JsonIgnore
    ShowEntity showEntity;
}
