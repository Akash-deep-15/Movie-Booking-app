package com.example.BookMyShow.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="shows")
@Builder
public class ShowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name ="show_date", nullable = false)
    private LocalDate showDate;
    @Column(name ="show_time", nullable = false)
    private LocalTime showTime;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date")
    private Date updatedAt;

    @OneToMany (mappedBy = "showEntity",cascade = CascadeType.ALL)
    @JsonIgnore
    List<TicketEntity> ticketEntity;

    @OneToMany (mappedBy = "showEntity", cascade = CascadeType.ALL)
    @JsonIgnore
    List<ShowSeatsEntity> showSeatEntity;

    @ManyToOne
    @JsonIgnore
    MovieEntity movieEntity;

    @ManyToOne
    @JsonIgnore
    TheatreEntity theatreEntity;
}
