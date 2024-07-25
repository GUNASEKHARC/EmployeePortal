package com.example.EmployeePortal.service;

import com.example.EmployeePortal.dto.EmployeeDto;
import com.example.EmployeePortal.entity.EmployeeEntity;
import com.example.EmployeePortal.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;
    public void details(EmployeeDto employeeDto){
        EmployeeEntity employeeEntity=new EmployeeEntity();
        LocalDate myObj = LocalDate.now();
       employeeEntity.setEmployeeId(employeeDto.getEmployeeId());
       employeeEntity.setDomain(employeeDto.getDomain());
       employeeEntity.setName(employeeDto.getName());
       employeeEntity.setDesignation(employeeDto.getDesignation());
       employeeEntity.setMobileNumber(employeeDto.getMobileNumber());
       employeeEntity.setJoiningDate(myObj);

       employeeRepo.save(employeeEntity);
    }

    public Optional<EmployeeEntity> view(Long id)
    {

        return employeeRepo.findById(id);
    }
    public List<EmployeeEntity> view1()
    {

        return employeeRepo.findAll();
    }
}
