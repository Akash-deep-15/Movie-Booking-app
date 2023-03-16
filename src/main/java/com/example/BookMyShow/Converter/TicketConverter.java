package com.example.BookMyShow.Converter;

import com.example.BookMyShow.DTO.TicketDTO;
import com.example.BookMyShow.Model.TicketEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TicketConverter {

    public TicketEntity dtoToEntity(TicketDTO ticketDto) {
        return TicketEntity.builder().amount(ticketDto.getAmount()).allotedSeat(ticketDto.getAllotedSeat()).build();
    }

    public TicketDTO EntityToDTO(TicketEntity ticketEntity) {
        return TicketDTO.builder().amount(ticketEntity.getAmount()).allotedSeat(ticketEntity.getAllotedSeat()).build();
    }

}
