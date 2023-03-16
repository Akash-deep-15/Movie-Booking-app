package com.example.BookMyShow.Service.implementation;

import com.example.BookMyShow.Converter.ShowConverter;
import com.example.BookMyShow.DTO.ShowDTO;
import com.example.BookMyShow.Model.*;
import com.example.BookMyShow.Reopsitory.MovieRepository;
import com.example.BookMyShow.Reopsitory.ShowRepository;
import com.example.BookMyShow.Reopsitory.ShowSeatsRepository;
import com.example.BookMyShow.Reopsitory.TheatreRepository;
import com.example.BookMyShow.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ShowServiceImpl implements ShowService {

    @Autowired
    ShowRepository showRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheatreRepository theatreRepository;


    @Override
    public void addShow(ShowDTO showDTO) {

        ShowEntity newShow = ShowConverter.dtoToEntity(showDTO);

        MovieEntity movie = movieRepository.findById(showDTO.getMovieDto().getId()).get();
        TheatreEntity theatre = theatreRepository.findById(showDTO.getTheaterDto().getId()).get() ;

        newShow.setMovieEntity(movie);
        newShow.setTheatreEntity(theatre);

        List<ShowSeatsEntity> seats = createShowSeats(theatre.getSeats(), newShow);
        newShow.setShowSeatEntity(seats);

        showRepository.save(newShow);
    }

    public List<ShowSeatsEntity> createShowSeats(List<TheatreSeatEntity> theatreSeats,ShowEntity showEntity) {

        List<ShowSeatsEntity> showSeats = new ArrayList<>();

        for(TheatreSeatEntity x: theatreSeats) {
            ShowSeatsEntity showSeat = ShowSeatsEntity.builder()
                    .seatNumber(x.getSeatNumber())
                    .seatType(x.getSeatType())
                    .rate(x.getRate()).build();

                showSeats.add(showSeat);
        }

        for(ShowSeatsEntity x: showSeats) {
            x.setShowEntity(showEntity);
        }

        showEntity.setShowSeatEntity(showSeats);

        return showSeats;
    }


    @Override
    public ShowDTO getShow(int id, ShowDTO showDTO) {
        ShowEntity findShow = showRepository.findById(id).get();
        ShowDTO foundShow = ShowConverter.entityToDto(findShow, showDTO );
        return foundShow;
    }
}
