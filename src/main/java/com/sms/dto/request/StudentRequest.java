package com.sms.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentRequest {

    private String name;
    private LocalDate dateOfBirth;
    private String gender;
    private String studentCode;
    private String email;
    private String phone;
    private String fatherName;
    private String motherName;
}
