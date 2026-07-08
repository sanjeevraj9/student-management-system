package com.sms.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentLoginRequest {
    private String studentCode;
    private LocalDate dateOfBirth;
}
