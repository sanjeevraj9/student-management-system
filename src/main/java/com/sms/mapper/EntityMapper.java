package com.sms.mapper;

import com.sms.dto.response.AddressResponse;
import com.sms.dto.response.CourseResponse;
import com.sms.dto.response.StudentResponse;
import com.sms.entity.Address;
import com.sms.entity.Course;
import com.sms.entity.Student;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.stream.Collectors;

@Component
public class EntityMapper {
    public StudentResponse toStudentResponse(Student student){
        return StudentResponse.builder()
                .id(student.getId())
                .name(student.getName())
                .dateOfBirth(student.getDateOfBirth())
                .gender(student.getGender())
                .studentCode(student.getStudentCode())
                .email(student.getEmail())
                .phone(student.getPhone())
                .fatherName(student.getFatherName())
                .motherName(student.getMotherName())
                .addresses(
                        student.getAddresses()==null
                                ? Collections.emptyList()
                                :student.getAddresses()
                .stream()
                .map(this::toAddressResponse)
                .collect(Collectors.toList()))
                .courses(
                        student.getCourses()==null
                                ? Collections.emptyList()
                                :student.getCourses()
                        .stream()
                        .map(this::toCourseResponse)
                        .collect(Collectors.toList()))
                .build();

    }

    public AddressResponse toAddressResponse(Address address){
    return AddressResponse.builder()
            .id(address.getId())
            .houseNo(address.getHouseNo())
            .city(address.getCity())
            .street(address.getStreet())
            .state(address.getState())
            .pincode(address.getPinCode())
            .addressType(address.getAddressType())
            .build();

    }
    public CourseResponse toCourseResponse(Course course){
        return CourseResponse.builder()
                .id(course.getId())
                .courseName(course.getCourseName())
                .description(course.getDescription())
                .courseType(course.getCourseType())
                .duration(course.getDuration())
                .topics(course.getTopic())
                .build();
    }

}
