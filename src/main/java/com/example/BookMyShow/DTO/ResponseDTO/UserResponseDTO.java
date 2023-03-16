package com.example.BookMyShow.DTO.ResponseDTO;

import com.example.BookMyShow.DTO.TicketDTO;
import com.example.BookMyShow.Model.TicketEntity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDTO {

    private int id;
    @NonNull
    private String name;
    @NonNull
    private String mobile;

    //optional
    List<TicketDTO> tickets;

}
