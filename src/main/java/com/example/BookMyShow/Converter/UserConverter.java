package com.example.BookMyShow.Converter;

import com.example.BookMyShow.DTO.EntryDTO.UserEntryDTO;

import com.example.BookMyShow.DTO.ResponseDTO.UserResponseDTO;
import com.example.BookMyShow.Model.UserEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserConverter {

    public static UserEntity dtoToEntity(UserEntryDTO userEntryDto) {

        return UserEntity.builder().name(userEntryDto.getName()).mobile(userEntryDto.getMobile()).build();  // id is auto incremented...
    }

    public static UserResponseDTO ToResponseDTO(UserEntity userEntity) {
        return UserResponseDTO.builder().id(userEntity.getId()).name(userEntity.getName())
                .mobile(userEntity.getMobile()).build();
    }


}
