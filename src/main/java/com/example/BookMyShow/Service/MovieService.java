package com.example.BookMyShow.Service;

import com.example.BookMyShow.DTO.EntryDTO.MovieEntryDTO;
import com.example.BookMyShow.DTO.ResponseDTO.MovieResponseDTO;


public interface MovieService {

    public void addMovie(MovieEntryDTO movieentryDto);


    public MovieResponseDTO getMovie(int id);


}
