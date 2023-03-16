package com.example.BookMyShow.DTO.ResponseDTO;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieResponseDTO {

    @NonNull
    private int id;
    private String name;
    private LocalDate releaseDate;

}
