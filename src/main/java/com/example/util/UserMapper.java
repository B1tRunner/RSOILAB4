package com.example.util;

import com.example.dto.UserDTO;
import com.example.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDTO mapToDTO(UserEntity user){
        return UserDTO.builder()
                .name(user.getName())
                .lastname(user.getLastname())
                .patronymic(user.getPatronymic())
                .dateOfBirth(user.getDateOfBirth())
                .sex(user.getSex())
                .passportSeries(user.getPassportSeries())
                .passportNumber(user.getPassportNumber())
                .issuedBy(user.getIssuedBy())
                .dateOfIssue(user.getDateOfIssue())
                .identificationNumber(user.getIdentificationNumber())
                .placeOfBirth(user.getPlaceOfBirth())
                .cityOfResidence(user.getCityOfResidence())
                .addressOfActualResidence(user.getAddressOfActualResidence())
                .addressOfResidence(user.getAddressOfResidence())
                .familyStatus(user.getFamilyStatus())
                .citizenship(user.getCitizenship())
                .disability(user.getDisability())
                .retired(user.getRetired())
                .militaryDue(user.getMilitaryDue())
                .build();
    }

    public UserEntity mapToEntity(UserDTO userDTO){
        return UserEntity.builder()
                .name(userDTO.getName())
                .lastname(userDTO.getLastname())
                .patronymic(userDTO.getPatronymic())
                .dateOfBirth(userDTO.getDateOfBirth())
                .sex(userDTO.getSex())
                .passportSeries(userDTO.getPassportSeries())
                .passportNumber(userDTO.getPassportNumber())
                .issuedBy(userDTO.getIssuedBy())
                .dateOfIssue(userDTO.getDateOfIssue())
                .identificationNumber(userDTO.getIdentificationNumber())
                .placeOfBirth(userDTO.getPlaceOfBirth())
                .cityOfResidence(userDTO.getCityOfResidence())
                .addressOfActualResidence(userDTO.getAddressOfActualResidence())
                .addressOfResidence(userDTO.getAddressOfResidence())
                .familyStatus(userDTO.getFamilyStatus())
                .citizenship(userDTO.getCitizenship())
                .disability(userDTO.getDisability())
                .retired(userDTO.getRetired())
                .militaryDue(userDTO.getMilitaryDue())
                .build();
    }

}
