package com.sms.controller;

import com.sms.dto.request.StudentLoginRequest;
import com.sms.dto.request.StudentUpdateRequest;
import com.sms.dto.response.CourseResponse;
import com.sms.dto.response.StudentResponse;
import com.sms.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    @Autowired
    private final StudentService studentService;

    @PostMapping("/login")
    public StudentResponse login(@RequestBody StudentLoginRequest request){
        return studentService.login(request);
    }
    @PutMapping("/{studentId}")
    public StudentResponse updateProfile(@PathVariable Long studentId, @RequestBody StudentUpdateRequest request){
        return studentService.updateProfile(studentId,request);
    }
    @GetMapping("{studentId}/course")
        public List<CourseResponse> getCourse(@PathVariable Long studentId){
            return studentService.getAssignedCourse(studentId);

    }
    @DeleteMapping("{studentId}/course/{courseId}")
    public String leaveCourse(@PathVariable Long studentId,
                              @PathVariable Long courseId){
        studentService.leaveCourse(studentId,courseId);

        return "Course leave";
    }

}
