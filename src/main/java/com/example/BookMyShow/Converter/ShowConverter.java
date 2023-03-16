package com.example.BookMyShow.Converter;

import com.example.BookMyShow.DTO.ShowDTO;
import com.example.BookMyShow.Model.ShowEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ShowConverter {

    public static ShowDTO entityToDto(ShowEntity showEntity, ShowDTO showDto) {
        return ShowDTO.builder().showDate(showEntity.getShowDate()).showTime(showEntity.getShowTime())
                .movieDto(showDto.getMovieDto()).theaterDto(showDto.getTheaterDto())
                .build();
    }

    public static ShowEntity dtoToEntity(ShowDTO showDTO) {
        return ShowEntity.builder().showDate(showDTO.getShowDate()).showTime(showDTO.getShowTime()).build();
    }

}
