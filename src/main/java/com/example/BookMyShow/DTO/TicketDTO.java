package com.example.BookMyShow.DTO;

import com.example.BookMyShow.DTO.ResponseDTO.UserResponseDTO;
import lombok.*;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketDTO {

    private int id;
    private double amount;
    private String allotedSeat;

    ShowDTO showDto;
    UserResponseDTO userDto;
}
