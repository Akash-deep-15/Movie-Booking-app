package com.example.BookMyShow.Controller;

import com.example.BookMyShow.DTO.EntryDTO.UserEntryDTO;
import com.example.BookMyShow.DTO.ResponseDTO.UserResponseDTO;
import com.example.BookMyShow.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody() UserEntryDTO userEntryDTO) {
         userService.addUser(userEntryDTO);
        return new ResponseEntity( "added a user", HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable(value = "id") int id) {
        UserResponseDTO userResponseDTO = userService.getUser(id);
        return new ResponseEntity(userResponseDTO,HttpStatus.OK);
    }

}
