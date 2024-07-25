package com.example.EmployeePortal.controller;

import com.example.EmployeePortal.dto.EmployeeDto;
import com.example.EmployeePortal.entity.EmployeeEntity;
import com.example.EmployeePortal.repository.EmployeeRepo;
import com.example.EmployeePortal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    private EmployeeRepo employeeRepo;

    @PostMapping("/adddetails")
    public void getId(@RequestBody EmployeeDto employeeDto) {
        employeeService.details(employeeDto);
    }
    @GetMapping("/getdetails")
    public Optional<EmployeeEntity> view(@RequestParam ("id") Long id){
       return employeeService.view(id);
    }
    @GetMapping("/getalldetails")
    public List<EmployeeEntity> view1(){
        return employeeService.view1();
    }
}//object