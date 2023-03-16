package com.example.BookMyShow.Service.implementation;

import com.example.BookMyShow.Converter.MovieCoverter;
import com.example.BookMyShow.DTO.EntryDTO.MovieEntryDTO;
import com.example.BookMyShow.DTO.ResponseDTO.MovieResponseDTO;
import com.example.BookMyShow.Model.MovieEntity;
import com.example.BookMyShow.Reopsitory.MovieRepository;
import com.example.BookMyShow.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;


    @Override
    public void addMovie(MovieEntryDTO movieEntryDto) {
        MovieEntity newMovie = MovieCoverter.dtoToEntity(movieEntryDto);
        movieRepository.save(newMovie);
    }

    @Override
    public MovieResponseDTO getMovie(int id) {
       MovieEntity findMovie = movieRepository.findById(id).get();
       MovieResponseDTO foundMovieDTO = MovieCoverter.EntityToDTO(findMovie);
       return foundMovieDTO;
    }
}
