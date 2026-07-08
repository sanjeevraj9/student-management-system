package com.sms.service;

import com.sms.dto.request.AddressRequest;
import com.sms.dto.request.StudentLoginRequest;
import com.sms.dto.request.StudentUpdateRequest;
import com.sms.dto.response.AddressResponse;
import com.sms.dto.response.CourseResponse;
import com.sms.dto.response.StudentResponse;

import java.util.List;

public interface StudentService {
    StudentResponse login(StudentLoginRequest request);
    StudentResponse updateProfile(Long id,StudentUpdateRequest request);
    List<CourseResponse> getAssignedCourse(Long studentId);
    void leaveCourse(Long studentId, Long courseId);
    AddressResponse updateAddress(Long studentId, Long addressId, AddressRequest request);

}
