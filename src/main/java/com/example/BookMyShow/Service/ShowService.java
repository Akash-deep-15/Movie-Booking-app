package com.example.BookMyShow.Service;

import com.example.BookMyShow.DTO.ShowDTO;
import com.example.BookMyShow.Model.ShowEntity;

public interface ShowService {

    public void addShow(ShowDTO showDTO);

    public ShowDTO getShow(int id, ShowDTO showDTO);
}
