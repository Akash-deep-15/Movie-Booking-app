package com.example.BookMyShow.Service.implementation;

import com.example.BookMyShow.Converter.TicketConverter;
import com.example.BookMyShow.DTO.BookingRequestDTO;
import com.example.BookMyShow.DTO.TicketDTO;
import com.example.BookMyShow.Model.ShowEntity;
import com.example.BookMyShow.Model.ShowSeatsEntity;
import com.example.BookMyShow.Model.TicketEntity;
import com.example.BookMyShow.Model.UserEntity;
import com.example.BookMyShow.Reopsitory.ShowRepository;
import com.example.BookMyShow.Reopsitory.TicketRepository;
import com.example.BookMyShow.Reopsitory.UserRepository;
import com.example.BookMyShow.Service.TicketService;
import com.example.BookMyShow.enums.SeatType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ShowRepository showRepository;

    @Override
    public void addTicket(BookingRequestDTO bookingRequestDTO) {

        UserEntity user = userRepository.findById(bookingRequestDTO.getId()).get();
        ShowEntity show = showRepository.findById(bookingRequestDTO.getShowId()).get();

        SeatType seatType = bookingRequestDTO.getSeatType();
        Set<String> requestedSeats = bookingRequestDTO.getRequestedSeats();

        List<ShowSeatsEntity> availableSeats = show.getShowSeatEntity();
        Set<String> allotedSeats;

        List<ShowSeatsEntity> bookedSeats = new ArrayList<>();

        for(ShowSeatsEntity x: availableSeats) {
            if(!x.isBooked() && x.getSeatType().equals(bookingRequestDTO.getSeatType()) && requestedSeats.contains(x.getSeatNumber())) {
                bookedSeats.add(x);
            }
        }

        if(bookedSeats.size() != requestedSeats.size()) {
            throw new Error("NO Available Seats");
        }

        TicketEntity newTicket = TicketEntity.builder().user(user).showEntity(show).showSeatsEntity(bookedSeats).build();

        double amount = 0;

        for(ShowSeatsEntity x: bookedSeats) {
            x.setBooked(true);
            x.setBookedAt(new Date());
            x.setTicketEntity(newTicket);

            amount += x.getRate();
        }

        newTicket.setBookeadAt(new Date());
        newTicket.setAllotedSeat(convertToString(bookedSeats));
        newTicket.setAmount(amount);

        show.getTicketEntity().add(newTicket);

        user.getTickets().add(newTicket);

        ticketRepository.save(newTicket);

        return;
    }

    public String convertToString(List<ShowSeatsEntity> seats) {

        String allotedSeats = "";

        for(ShowSeatsEntity X: seats) {
            allotedSeats += X.getSeatNumber()+" ";
        }

        return allotedSeats;
    }

    @Override
    public TicketDTO getTicket(int id) {
        TicketEntity findTicket = ticketRepository.findById(id).get();
        TicketDTO foundTicket = TicketConverter.EntityToDTO(findTicket);
        return foundTicket;
    }
}
