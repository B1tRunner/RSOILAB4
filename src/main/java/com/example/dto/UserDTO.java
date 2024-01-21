package com.example.dto;

import com.example.enums.Citizenship;
import com.example.enums.Disability;
import com.example.enums.FamilyStatus;
import com.example.enums.CityOfResidence;
import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
@Builder
public class UserDTO {
    private String name;
    private String lastname;
    private String patronymic;

    private Date dateOfBirth;

    private Boolean sex;
    private String passportSeries;
    private String passportNumber;
    private String issuedBy;

    private Date dateOfIssue;

    private String identificationNumber;
    private String placeOfBirth;

    private CityOfResidence cityOfResidence;
    private String addressOfActualResidence;
    private String addressOfResidence;

    private FamilyStatus familyStatus;
    private Citizenship citizenship;
    private Disability disability;
    private Boolean retired;
    private Boolean militaryDue;
}
