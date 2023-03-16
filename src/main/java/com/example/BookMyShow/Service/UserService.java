package com.example.BookMyShow.Service;

import com.example.BookMyShow.DTO.EntryDTO.UserEntryDTO;
import com.example.BookMyShow.DTO.ResponseDTO.UserResponseDTO;

public interface UserService {

    // add
    public UserResponseDTO addUser(UserEntryDTO userDto) ;
    // get
    public UserResponseDTO getUser(int id);
}
