package com.sms.dto.request;

import lombok.Data;

@Data
public class StudentUpdateRequest {
    private String email;
    private String fatherName;
    private String motherName;
    private String phone;


}
