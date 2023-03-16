package com.example.BookMyShow.Controller;

import com.example.BookMyShow.DTO.EntryDTO.TheatreEntryDTO;
import com.example.BookMyShow.DTO.ResponseDTO.TheatreResponseDTO;
import com.example.BookMyShow.Service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("theatres")
public class TheatreController {

    @Autowired
    TheatreService theatreService;

    @PostMapping("/add")
    public ResponseEntity addTheatre(@RequestBody()TheatreEntryDTO theatreEntryDTO) {
        theatreService.addTheatre(theatreEntryDTO);
        return new ResponseEntity("new theatre added", HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<TheatreResponseDTO> getTheatre(@PathVariable(value="id") int id) {
        TheatreResponseDTO theatreResponseDTO = theatreService.getTheatre(id);
        return new ResponseEntity(theatreResponseDTO,HttpStatus.ACCEPTED);
    }
}
