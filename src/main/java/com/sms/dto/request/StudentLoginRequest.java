package com.sms.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentLoginRequest {
    @NotBlank
    private String studentCode;
    @NotNull
    private LocalDate dateOfBirth;
}
