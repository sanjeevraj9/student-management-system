package com.sms.service;

import com.sms.dto.request.*;
import com.sms.dto.response.AddressResponse;
import com.sms.dto.response.CourseResponse;
import com.sms.dto.response.StudentResponse;

import java.util.List;

public interface AdminService {

    String login(AdminLoginRequest request);
    StudentResponse addStudent(StudentRequest request);
    AddressResponse addAddress(Long id,AddressRequest request);
    CourseResponse addCourses(CourseRequest request);
    void assignCourse(AssignCourseName request);
    List<StudentResponse> searchStudent(String name);
    List<StudentResponse> getStudentByCourse(Long courseId);

}
