package com.sms.service.impl;

import com.sms.dto.request.StudentLoginRequest;
import com.sms.dto.request.StudentRequest;
import com.sms.dto.request.StudentUpdateRequest;
import com.sms.dto.response.CourseResponse;
import com.sms.dto.response.StudentResponse;
import com.sms.entity.Course;
import com.sms.entity.Student;
import com.sms.exception.ResourceNotFoundException;
import com.sms.mapper.EntityMapper;
import com.sms.repository.CourseRepository;
import com.sms.repository.StudentRepository;
import com.sms.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final EntityMapper entityMapper;

    @Override
    public StudentResponse login(StudentLoginRequest request){
        Student student=studentRepository
                .findByStudentCodeAndDateOfBirth(
                        request.getStudentCode(),
                        request.getDateOfBirth())
                .orElseThrow(()-> new ResourceNotFoundException("Invalid details"));

        return entityMapper.toStudentResponse(student);
    }

    @Override
    public StudentResponse updateProfile(Long id, StudentUpdateRequest request){
        Student student=studentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Student not found"));

        student.setEmail(request.getEmail());
        student.setPhone(request.getPhone());
        student.setFatherName(request.getFatherName());
        student.setMotherName(request.getMotherName());
        studentRepository.save(student);
        return entityMapper.toStudentResponse(student);
    }

    @Override
    public List<CourseResponse> getAssignedCourse(Long studentId){
        Student student=studentRepository.findById(studentId)
                .orElseThrow(()-> new ResourceNotFoundException("Student not FOund"));
        return student.getCourses()
                .stream()
                .map(entityMapper::toCourseResponse)
                .toList();
    }

    @Override
    public void leaveCourse(Long studentId,Long courseId){
        Student student=studentRepository.findById(studentId)
                .orElseThrow(()-> new ResourceNotFoundException("Student not found"));

        Course course=courseRepository.findById(courseId)
                .orElseThrow(()-> new ResourceNotFoundException("Course not Found"));

        student.getCourses().remove(course);
        studentRepository.save(student);
        }
}




