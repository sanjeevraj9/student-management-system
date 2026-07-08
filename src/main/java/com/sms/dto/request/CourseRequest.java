package com.sms.dto.request;

import lombok.Data;

@Data
public class CourseRequest {

    private String courseName;
    private String description;
    private String courseType;
    private String topics;
    private Integer duration;
}
