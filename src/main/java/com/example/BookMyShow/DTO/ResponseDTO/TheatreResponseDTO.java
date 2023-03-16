package com.example.BookMyShow.DTO.ResponseDTO;

import com.example.BookMyShow.enums.TheatreType;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class TheatreResponseDTO {

    @NonNull
    int id;

    String name;
    String city;
    String address;
    TheatreType theatreType;
}
