package com.sms.controller;

import com.sms.dto.request.*;
import com.sms.dto.response.AddressResponse;
import com.sms.dto.response.CourseResponse;
import com.sms.dto.response.StudentResponse;
import com.sms.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    @Autowired
    private final AdminService adminService;

    @PostMapping("/login")
    public String login(@RequestBody AdminLoginRequest request){
        return adminService.login(request);
    }
    @PostMapping("/student")
    public StudentResponse addStudent(@RequestBody StudentRequest request){
        return adminService.addStudent(request);
    }

    @PostMapping("/student/{studentId}/address")
    public AddressResponse addAddress(@PathVariable Long studentId, @RequestBody AddressRequest request){
        return adminService.addAddress(studentId,request);
    }

    @PostMapping("/course")
    public CourseResponse addCourse(@RequestBody CourseRequest request){
        return adminService.addCourses(request);
    }

    @PostMapping("/assign-course")
    public String addAssignedCourse(@RequestBody AssignCourseName request){
        adminService.assignCourse(request);
        return "Course Assigned Successfully";
    }

    @GetMapping("/students")
    public List<StudentResponse> searchStudents(@RequestParam String name){
        return adminService.searchStudent(name);
    }
    @GetMapping("/course/{courseId}/students")
    public List<StudentResponse> getStudentByCourse(@PathVariable Long courseId){
        return adminService.getStudentByCourse(courseId);
    }

}
