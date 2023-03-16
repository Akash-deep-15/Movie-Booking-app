package com.example.BookMyShow.DTO;

import com.example.BookMyShow.DTO.ResponseDTO.MovieResponseDTO;
import com.example.BookMyShow.DTO.ResponseDTO.TheatreResponseDTO;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class ShowDTO {

    @NonNull
    LocalDate showDate;
    @NonNull
    LocalTime showTime;

    @NotNull
    MovieResponseDTO movieDto;

    @NotNull
    TheatreResponseDTO theaterDto;
}
