package com.sms.controller;

import com.sms.dto.request.AddressRequest;
import com.sms.dto.request.StudentLoginRequest;
import com.sms.dto.request.StudentUpdateRequest;
import com.sms.dto.response.AddressResponse;
import com.sms.dto.response.CourseResponse;
import com.sms.dto.response.StudentResponse;
import com.sms.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/login")
    public ResponseEntity<StudentResponse> login(@RequestBody StudentLoginRequest request){

        return ResponseEntity.ok(studentService.login(request));
    }
    @PutMapping("/{studentId}")
    public ResponseEntity<StudentResponse> updateProfile(@PathVariable Long studentId, @RequestBody StudentUpdateRequest request){
        return ResponseEntity.ok(studentService.updateProfile(studentId,request));
    }
    @GetMapping("{studentId}/courses")
        public ResponseEntity<List<CourseResponse>> getCourse(@PathVariable Long studentId){
            return ResponseEntity.ok(studentService.getAssignedCourse(studentId));

    }

    @PutMapping("/{studentId}/address/{addressId}")
    public ResponseEntity<AddressResponse> updateAddress(@PathVariable Long studentId,
                                                         @PathVariable Long addressId,
                                                         @RequestBody AddressRequest request){
        return ResponseEntity.ok(
                studentService.updateAddress(studentId,addressId,request));
                }
    @DeleteMapping("{studentId}/course/{courseId}")
    public ResponseEntity<String> leaveCourse(@PathVariable Long studentId,
                                      @PathVariable Long courseId){

        studentService.leaveCourse(studentId,courseId);

        return ResponseEntity.ok("Course leave");
    }


}
