package com.sms.controller;

import com.sms.dto.request.*;
import com.sms.dto.response.AddressResponse;
import com.sms.dto.response.CourseResponse;
import com.sms.dto.response.StudentResponse;
import com.sms.service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AdminLoginRequest request){
        return ResponseEntity.ok(adminService.login(request));
    }
    @PostMapping("/student")
    public ResponseEntity<StudentResponse> addStudent(@Valid @RequestBody StudentRequest request){

        return ResponseEntity.ok(adminService.addStudent(request));
    }

    @PostMapping("/student/{studentId}/address")
    public ResponseEntity<AddressResponse> addAddress(@PathVariable Long studentId, @RequestBody AddressRequest request){
        return ResponseEntity.ok(adminService.addAddress(studentId,request));
    }

    @PostMapping("/course")
    public ResponseEntity<CourseResponse> addCourse(@RequestBody CourseRequest request){

        return ResponseEntity.ok(adminService.addCourses(request));
    }

    @PostMapping("/assign-course")
    public ResponseEntity<String> addAssignedCourse(@RequestBody AssignCourseName request){
        adminService.assignCourse(request);
        return ResponseEntity.ok("Course Assigned Successfully");
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentResponse>> searchStudents(@RequestParam String name){
        return ResponseEntity.ok(adminService.searchStudent(name));
    }
    @GetMapping("/course/{courseId}/students")
    public ResponseEntity<List<StudentResponse>> getStudentByCourse(@PathVariable Long courseId){
        return ResponseEntity.ok(adminService.getStudentByCourse(courseId));
    }

}
