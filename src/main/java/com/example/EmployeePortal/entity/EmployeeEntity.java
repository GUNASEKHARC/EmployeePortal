package com.example.EmployeePortal.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
@Entity
@Table
@Data@RequiredArgsConstructor
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeId;
    private String name;
    private String domain;
    private String designation;
    private long mobileNumber;
    private String joiningDate;

}
