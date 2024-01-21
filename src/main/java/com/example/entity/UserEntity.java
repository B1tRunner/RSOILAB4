package com.example.entity;

import com.example.enums.Citizenship;
import com.example.enums.Disability;
import com.example.enums.FamilyStatus;
import com.example.enums.CityOfResidence;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user_entity")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String lastname;
    private String patronymic;

    @Temporal(TemporalType.DATE)
    @Column(updatable = false)
    private Date dateOfBirth;

    @Column(updatable = false)
    private Boolean sex;

    private String passportSeries;
    private String passportNumber;

    private String issuedBy;

    @Temporal(TemporalType.DATE)
    private Date dateOfIssue;

    @Column(unique = true)
    private String identificationNumber;

    @Column(updatable = false)
    private String placeOfBirth;

    @Enumerated(EnumType.STRING)
    private CityOfResidence cityOfResidence;

    private String addressOfActualResidence;
    private String addressOfResidence;

    @Enumerated(EnumType.STRING)
    private FamilyStatus familyStatus;
    @Enumerated(EnumType.STRING)
    private Citizenship citizenship;
    @Enumerated(EnumType.STRING)
    private Disability disability;

    private Boolean retired;
    private Boolean militaryDue;

}
