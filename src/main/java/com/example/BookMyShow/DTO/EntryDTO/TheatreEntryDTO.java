package com.example.BookMyShow.DTO.EntryDTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TheatreEntryDTO {
    String name;
    String city;
    String address;
}
