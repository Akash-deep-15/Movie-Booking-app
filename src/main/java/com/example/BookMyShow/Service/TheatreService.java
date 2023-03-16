package com.example.BookMyShow.Service;

import com.example.BookMyShow.DTO.EntryDTO.TheatreEntryDTO;
import com.example.BookMyShow.DTO.ResponseDTO.TheatreResponseDTO;

public interface TheatreService {

    public void addTheatre(TheatreEntryDTO theatreEntryDTO);

    public TheatreResponseDTO getTheatre(int id);
}
