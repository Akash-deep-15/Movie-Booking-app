package com.example.BookMyShow.Controller;

import com.example.BookMyShow.DTO.EntryDTO.MovieEntryDTO;
import com.example.BookMyShow.DTO.ResponseDTO.MovieResponseDTO;
import com.example.BookMyShow.Reopsitory.MovieRepository;
import com.example.BookMyShow.Service.MovieService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add")
        public ResponseEntity addMovie(@RequestBody()MovieEntryDTO movieEntryDTO) {
        movieService.addMovie(movieEntryDTO);
        return new ResponseEntity("movie added successfully", HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<MovieResponseDTO> getMovie(@PathVariable int id) {
        MovieResponseDTO movieResponseDTO = movieService.getMovie(id);
        return new ResponseEntity(movieResponseDTO,HttpStatus.ACCEPTED);
    }

}
