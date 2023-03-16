package com.example.BookMyShow.DTO.EntryDTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntryDTO {

    @NonNull
    String name;
    @NonNull
    String mobile;
}
