package com.example.BookMyShow.Converter;

import com.example.BookMyShow.DTO.EntryDTO.MovieEntryDTO;
import com.example.BookMyShow.DTO.ResponseDTO.MovieResponseDTO;
import com.example.BookMyShow.Model.MovieEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MovieCoverter {

    public static MovieEntity dtoToEntity(MovieEntryDTO movieEntryDTO) {
        return MovieEntity.builder().name(movieEntryDTO.getName()).
                releaseDate(movieEntryDTO.getReleaseDate()).build();
    }

    public static MovieResponseDTO EntityToDTO(MovieEntity movieEntity) {
        return MovieResponseDTO.builder().id(movieEntity.getId()).name(movieEntity.getName()).releaseDate(movieEntity.getReleaseDate()).build();
    }
}
