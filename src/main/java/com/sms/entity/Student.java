package com.sms.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name="students")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private LocalDate dateOfBirth;

    private String gender;

    @Column(nullable = false,unique = true)
    private String studentCode;

    private String email;
    private String phone;
    private String fatherName;
    private String motherName;

    @OneToMany(mappedBy = "student",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Address> addresses;

    @ManyToMany
    @JoinTable(
            name = "student_course",
    joinColumns = @JoinColumn(name = "student_id"),
    inverseJoinColumns=@JoinColumn(name = "course_id"))
    private Set<Course> courses;

}
