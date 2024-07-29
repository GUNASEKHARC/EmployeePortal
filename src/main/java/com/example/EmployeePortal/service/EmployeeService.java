package com.example.EmployeePortal.service;

import com.example.EmployeePortal.dto.EmployeeDto;
import com.example.EmployeePortal.entity.EmployeeEntity;
import com.example.EmployeePortal.repository.CustomRepo;
import com.example.EmployeePortal.repository.EmployeeRepo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    CustomRepo repo;

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    private DataSourceTransactionManagerAutoConfiguration dataSourceTransactionManagerAutoConfiguration;

    public void details(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        LocalDate myObj = LocalDate.now();
        employeeEntity.setEmployeeId(employeeDto.getEmployeeId());
        employeeEntity.setDomain(employeeDto.getDomain());
        employeeEntity.setName(employeeDto.getName());
        employeeEntity.setDesignation(employeeDto.getDesignation());
        employeeEntity.setMobileNumber(employeeDto.getMobileNumber());
        employeeEntity.setJoiningDate(String.valueOf(myObj));

        employeeRepo.save(employeeEntity);
    }

    public Optional<EmployeeEntity> view(Long id) {
        return employeeRepo.findById(id);
    }

    public List<EmployeeEntity> view1() {
        return employeeRepo.findAll();
    }

    public List<EmployeeEntity> getByFilter(HttpServletRequest request) {
        Map<String, String[]> headers = request.getParameterMap();
        String sql = buildQuery(headers);
        System.out.println(sql);
        return repo.getByFilter(sql);
    }

    private String buildQuery(Map<String, String[]> headers) {
        String sql = "SELECT a FROM EmployeeEntity a ";
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String[]> entry : headers.entrySet()) {
            sb.append("TRIM(a.").append(entry.getKey()).append(") = '").append(entry.getValue()[0].trim()).append("' AND ");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 5); // Remove the trailing " AND "
            return sql + "WHERE " + sb.toString();
        }
        return sql;
    }
}
