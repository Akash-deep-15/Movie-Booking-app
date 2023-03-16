package com.example.BookMyShow.Service.implementation;

import com.example.BookMyShow.Converter.TheatreConverter;
import com.example.BookMyShow.DTO.EntryDTO.TheatreEntryDTO;
import com.example.BookMyShow.DTO.ResponseDTO.TheatreResponseDTO;
import com.example.BookMyShow.Model.TheatreEntity;
import com.example.BookMyShow.Model.TheatreSeatEntity;
import com.example.BookMyShow.Reopsitory.TheatreRepository;
import com.example.BookMyShow.Reopsitory.TheatreSeatRepository;
import com.example.BookMyShow.Service.TheatreService;
import com.example.BookMyShow.enums.SeatType;
import com.example.BookMyShow.enums.TheatreType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
public class TheatreServiceImpl implements TheatreService {

    @Autowired
    TheatreSeatRepository theatreSeatRepository;

    @Autowired
    TheatreRepository theatreRepository;

    @Override
    public void addTheatre(TheatreEntryDTO theatreEntryDTO) {

        TheatreEntity newTheatre = TheatreConverter.dtoToEntity(theatreEntryDTO);

        List<TheatreSeatEntity> seats = createSeats();

        newTheatre.setSeats(seats);

        newTheatre.setShows(null);

        for(TheatreSeatEntity x: seats) {
            x.setTheatreEntity(newTheatre);
        }
        newTheatre.setTheatreType(TheatreType.SINGLE);

        log.info("The theater entity is "+ newTheatre);

        theatreRepository.save(newTheatre);
        theatreSeatRepository.saveAll(seats);


    }

    public List<TheatreSeatEntity> createSeats() {
            List<TheatreSeatEntity> seats = new ArrayList<>();

            seats.add(createSingleSeat("1A", 100, SeatType.CLASSIC));
            seats.add(createSingleSeat("2A", 100, SeatType.CLASSIC));
            seats.add(createSingleSeat("3A", 100, SeatType.CLASSIC));
            seats.add(createSingleSeat("4A", 100, SeatType.CLASSIC));
            seats.add(createSingleSeat("5A", 100, SeatType.CLASSIC));

            seats.add(createSingleSeat("1B", 200, SeatType.PREMIUM));
            seats.add(createSingleSeat("2B", 200, SeatType.PREMIUM));
            seats.add(createSingleSeat("3B", 200, SeatType.PREMIUM));
            seats.add(createSingleSeat("4B", 200, SeatType.PREMIUM));
            seats.add(createSingleSeat("5B", 200, SeatType.PREMIUM));

            return seats;
    }

    public TheatreSeatEntity createSingleSeat(String seatNo, int rate, SeatType seatType) {
        return TheatreSeatEntity.builder().seatNumber(seatNo).rate(rate).seatType(seatType).build();
    }

    @Override
    public TheatreResponseDTO getTheatre(int id) {
        TheatreEntity findTheatre = theatreRepository.findById(id).get();
        TheatreResponseDTO foundTheatre = TheatreConverter.entityToDto(findTheatre);
        return foundTheatre;
    }
}
