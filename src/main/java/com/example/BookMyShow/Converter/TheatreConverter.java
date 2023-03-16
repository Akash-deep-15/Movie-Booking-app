package com.example.BookMyShow.Converter;

import com.example.BookMyShow.DTO.EntryDTO.TheatreEntryDTO;
import com.example.BookMyShow.DTO.ResponseDTO.TheatreResponseDTO;
import com.example.BookMyShow.Model.TheatreEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TheatreConverter {

    public static TheatreEntity dtoToEntity(TheatreEntryDTO theatreDTO) {
        return TheatreEntity.builder().name(theatreDTO.getName())
                .address(theatreDTO.getAddress())
                .city(theatreDTO.getCity()).build();
    }

    public static TheatreResponseDTO entityToDto(TheatreEntity theatreEntity) {
        return TheatreResponseDTO.builder().name(theatreEntity.getName()).address(theatreEntity.getAddress())
                .city(theatreEntity.getCity()).id(theatreEntity.getId()).theatreType(theatreEntity.getTheatreType()).build();
    }

}
