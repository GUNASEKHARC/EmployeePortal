package com.example.EmployeePortal.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class EmployeeDto {
    private int employeeId;
    private String name;
    private String domain;
    private String designation;
    private long mobileNumber;

}
