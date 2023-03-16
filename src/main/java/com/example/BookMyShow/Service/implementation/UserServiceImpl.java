package com.example.BookMyShow.Service.implementation;

import com.example.BookMyShow.Converter.UserConverter;
import com.example.BookMyShow.DTO.EntryDTO.UserEntryDTO;


import com.example.BookMyShow.DTO.ResponseDTO.UserResponseDTO;
import com.example.BookMyShow.Model.UserEntity;
import com.example.BookMyShow.Reopsitory.UserRepository;
import com.example.BookMyShow.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserResponseDTO addUser(UserEntryDTO userEntryDTO) {

        UserEntity userEntity = UserConverter.dtoToEntity(userEntryDTO);
        userRepository.save(userEntity);
        UserResponseDTO userResponseDTO = UserConverter.ToResponseDTO(userEntity);
        return userResponseDTO;
    }

    @Override
    public UserResponseDTO getUser(int id) {

        UserEntity userEntity = userRepository.findById(id).get();

        UserResponseDTO userResponseDTO = UserConverter.ToResponseDTO(userEntity);

        return userResponseDTO;
    }
}
