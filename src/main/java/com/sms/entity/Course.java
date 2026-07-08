package com.sms.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "courses")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;

    @Column(length = 1000)
    private String description;

    private String courseType;
    private Integer duration;
    private String topic;
    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;

}
