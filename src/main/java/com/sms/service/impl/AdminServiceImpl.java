package com.sms.service.impl;

import com.sms.dto.request.*;
import com.sms.dto.response.AddressResponse;
import com.sms.dto.response.CourseResponse;
import com.sms.dto.response.StudentResponse;
import com.sms.entity.Address;
import com.sms.entity.Admin;
import com.sms.entity.Course;
import com.sms.entity.Student;
import com.sms.exception.BadRequestException;
import com.sms.exception.ResourceNotFoundException;
import com.sms.mapper.EntityMapper;
import com.sms.repository.AddressRepository;
import com.sms.repository.AdminRepository;
import com.sms.repository.CourseRepository;
import com.sms.repository.StudentRepository;
import com.sms.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    @Autowired
    private final AdminRepository adminRepository;
    @Autowired
    private final StudentRepository studentRepository;
    @Autowired
    private final CourseRepository courseRepository;
    @Autowired
    private final AddressRepository addressRepository;
    @Autowired
    private final EntityMapper entityMapper;

    @Autowired
    private final PasswordEncoder encoder;

    @Override
    public StudentResponse addStudent(StudentRequest request) {
        Student student = Student.builder()
                .name(request.getName())
                .dateOfBirth(request.getDateOfBirth())
                .gender(request.getGender())
                .studentCode(request.getStudentCode())
                .email(request.getEmail())
                .phone(request.getPhone())
                .fatherName(request.getFatherName())
                .motherName(request.getMotherName())
                .build();
        studentRepository.save(student);
        return entityMapper.toStudentResponse(student);
    }

    @Override
    public CourseResponse addCourses(CourseRequest request) {
        Course course = Course.builder()
                .courseName(request.getCourseName())
                .description(request.getDescription())
                .courseType(request.getCourseType())
                .duration(request.getDuration())
                .topic(request.getTopics())
                .build();
        courseRepository.save(course);
        return entityMapper.toCourseResponse(course);

    }

    @Override
    public AddressResponse addAddress(Long id, AddressRequest request) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Address address = Address.builder()
                .houseNo(request.getHouseNo())
                .street(request.getStreet())
                .city(request.getCity())
                .state(request.getState())
                .pinCode(request.getPincode())
                .addressType(request.getAddressType())
                .student(student)
                .build();

        addressRepository.save(address);
        return entityMapper.toAddressResponse(address);

    }

    @Override
    public void assignCourse(AssignCourseName request) {
        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));

        student.getCourses().add(course);
        studentRepository.save(student);

    }

    @Override
    public List<StudentResponse> searchStudent(String name){
        return studentRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(entityMapper::toStudentResponse)
                .toList();
    }

    @Override
    public List<StudentResponse> getStudentByCourse(Long courseId){
        return studentRepository.findStudentsByCourseId(courseId)
                .stream()
                .map(entityMapper::toStudentResponse)
                .toList();
    }

    @Override
    public String login(AdminLoginRequest request){
        Admin admin=adminRepository.findByUsername(request.getUsername())
                .orElseThrow(()-> new ResourceNotFoundException("Invalid User"));

        if(!encoder.matches(request.getPassword(),admin.getPassword())){
            throw new BadRequestException("Invalid Password");
        }
        return "Login Successfull";
    }

}

