package com.example.service;

import com.example.dto.UserDTO;
import com.example.entity.UserEntity;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    List<UserEntity> getAllUsers();
    UserDTO getUser(int id) throws Exception;
    UserDTO updateUser(UserDTO updatedCitizen, int id) throws Exception;
    void deleteUser(int id) throws Exception;
    List<UserDTO> createUsers(List<UserDTO> listOfUserDTO);
}
