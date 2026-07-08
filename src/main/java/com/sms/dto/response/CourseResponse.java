package com.sms.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CourseResponse {
    private Long id;
    private String courseName;
    private String description;
    private String courseType;
    private String topics;
    private Integer duration;

}
