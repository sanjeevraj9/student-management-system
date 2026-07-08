package com.sms.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentRequest {
    @NotBlank(message = "Name is Required")
    private String name;
    @NotNull(message = "Date Of Birth is Required")
    private LocalDate dateOfBirth;
    @NotBlank(message = "Gender is required")
    private String gender;
    @NotBlank(message = "Give Me Unique Student Code")
    private String studentCode;
    @Email
    @NotBlank(message = "Email is Required")
    private String email;
    @Pattern(regexp = "^[0-9]{10}$",message = "Phone number must be a 10 digit")
    private String phone;
    private String fatherName;
    private String motherName;
}
