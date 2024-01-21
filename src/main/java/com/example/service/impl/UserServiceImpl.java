package com.example.service.impl;

import com.example.dto.UserDTO;
import com.example.entity.UserEntity;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import com.example.util.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        UserEntity userEntity = userMapper.mapToEntity(userDTO);
        userRepository.save(userEntity);
        return userMapper.mapToDTO(userEntity);
    }

    public List<UserDTO> createUsers(List<UserDTO> users) {
        List<UserEntity> userEntities = users.stream()
                .map(this.userMapper::mapToEntity)
                .collect(Collectors.toList());
        List<UserEntity> createdUserEntities = userRepository.saveAll(userEntities);

        return createdUserEntities.stream()
                .map(this.userMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDTO getUser(int id) throws Exception {
        var user = userRepository.findById(id).orElseThrow(() ->
                new Exception("user " + id + " not found"));
        return userMapper.mapToDTO(user);
    }

    @Override
    public UserDTO updateUser(UserDTO updatedUser, int id) throws Exception {
        UserEntity userEntityToBeUpdated = userRepository.findById(id).orElseThrow(() ->
                new Exception("user " + id + " not found"));

        userEntityToBeUpdated.setName(updatedUser.getName());
        userEntityToBeUpdated.setLastname(updatedUser.getLastname());
        userEntityToBeUpdated.setPatronymic(updatedUser.getPatronymic());

        userEntityToBeUpdated.setCityOfResidence(updatedUser.getCityOfResidence());
        userEntityToBeUpdated.setAddressOfResidence(updatedUser.getAddressOfResidence());
        userEntityToBeUpdated.setAddressOfActualResidence(updatedUser.getAddressOfActualResidence());

        userEntityToBeUpdated.setPassportSeries(updatedUser.getPassportSeries());
        userEntityToBeUpdated.setPassportNumber(updatedUser.getPassportNumber());
        userEntityToBeUpdated.setIssuedBy(updatedUser.getIssuedBy());
        userEntityToBeUpdated.setDateOfIssue(updatedUser.getDateOfIssue());

        userEntityToBeUpdated.setDisability(updatedUser.getDisability());
        userEntityToBeUpdated.setFamilyStatus(updatedUser.getFamilyStatus());
        userEntityToBeUpdated.setMilitaryDue(updatedUser.getMilitaryDue());
        userEntityToBeUpdated.setRetired(updatedUser.getRetired());

        userRepository.save(userEntityToBeUpdated);
        return userMapper.mapToDTO(userEntityToBeUpdated);
    }

    @Override
    public void deleteUser(int id) throws Exception {
        UserEntity userEntityToBeDeleted = userRepository.findById(id).orElseThrow(() ->
                new Exception("user \" + id + \" not found"));
        userRepository.delete(userEntityToBeDeleted);
    }

}
