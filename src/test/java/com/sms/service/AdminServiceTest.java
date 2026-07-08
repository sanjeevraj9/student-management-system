package com.sms.service;

import com.sms.dto.request.StudentRequest;
import com.sms.dto.response.StudentResponse;
import com.sms.entity.Student;
import com.sms.mapper.EntityMapper;
import com.sms.repository.AddressRepository;
import com.sms.repository.AdminRepository;
import com.sms.repository.CourseRepository;
import com.sms.repository.StudentRepository;
import com.sms.service.impl.AdminServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AdminServiceTest {

    @Mock
    private StudentRepository studentRepository;
    @Mock
    private AdminRepository adminRepository;
    @Mock
    private CourseRepository courseRepository;
    @Mock
    private AddressRepository addressRepository;
    @Mock
    private EntityMapper entityMapper;
    @Mock
    private PasswordEncoder passwordEncoder;
    @InjectMocks
    private AdminServiceImpl adminService;

    @Test
    void addStudent(){
        StudentRequest request=new StudentRequest();
        request.setName("Sanjeev Raj");
        request.setStudentCode("STU001");

        Student student=Student.builder()
                .name("Sanjeev Raj")
                .studentCode("STU001")
                .build();

        StudentResponse response=StudentResponse.builder()
                .name("Sanjeev Raj")
                .studentCode("STU001")
                .build();

        when(studentRepository.save(any(Student.class)))
                .thenReturn(student);

        when(entityMapper.toStudentResponse(any(Student.class)))
                .thenReturn(response);

        StudentResponse result=adminService.addStudent(request);
        assertEquals("Sanjeev Raj",result.getName());

        verify(studentRepository,times(1))
                .save(any(Student.class));
    }
}
