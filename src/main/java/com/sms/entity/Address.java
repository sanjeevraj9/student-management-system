package com.sms.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name="addresses")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String houseNo;
    private String street;
    private String city;
    private String state;
    private String pinCode;
    private String addressType;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

}
