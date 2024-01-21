package com.example.controller;

import com.example.dto.UserDTO;
import com.example.entity.UserEntity;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO newbornUserDTO){
        UserDTO userDTO = userService.createUser(newbornUserDTO);
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(userDTO);
    }

    @PostMapping("/batch")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<List<UserDTO>> createUsers(@RequestBody List<UserDTO> userDTOS) {
        List<UserDTO> createdUsers = userService.createUsers(userDTOS);
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(createdUsers);
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> getUsers(){
        var response =  userService.getAllUsers();
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("id") int id) throws Exception {
        var response =  userService.getUser(id);
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") int id,
                                                     @RequestBody UserDTO userDTO) throws Exception {
        UserDTO response = userService.updateUser(userDTO, id);
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id) throws Exception {
        userService.deleteUser(id);
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body("user deleted successfully");
    }

}
