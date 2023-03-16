package com.example.BookMyShow.DTO.EntryDTO;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
public class MovieEntryDTO {

    @NonNull
    String name;

    @NonNull
    LocalDate releaseDate;
}
