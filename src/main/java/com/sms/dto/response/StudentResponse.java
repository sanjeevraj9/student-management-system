package com.sms.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class StudentResponse {
    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    private String gender;
    private String studentCode;
    private String email;
    private String phone;
    private String fatherName;
    private String motherName;
    private List<AddressResponse> addresses;
    private List<CourseResponse> courses;

}
