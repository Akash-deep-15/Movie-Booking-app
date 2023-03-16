package com.example.BookMyShow.Service;

import com.example.BookMyShow.DTO.BookingRequestDTO;
import com.example.BookMyShow.DTO.TicketDTO;

public interface TicketService {

    public void addTicket(BookingRequestDTO bookingRequestDTO);

    public TicketDTO getTicket(int id);
}
