package com.sms.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CourseRequest {
    @NotBlank(message = "Course Name Is Required")
    private String courseName;
    private String description;
    @NotBlank(message = "Course type is required")
    private String courseType;
    @NotBlank(message = "Add Topics")
    private String topics;
    @NotNull
    @Positive(message = "Duration is greater than 0")
    private Integer duration;
}
