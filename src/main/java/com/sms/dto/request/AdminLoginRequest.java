package com.sms.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AdminLoginRequest {
    @NotBlank(message = "Username is Required")
    private String username;
    @NotBlank(message = "Password is required")
    private String password;

}
