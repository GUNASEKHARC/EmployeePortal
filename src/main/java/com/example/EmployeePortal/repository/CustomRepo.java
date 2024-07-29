package com.example.EmployeePortal.repository;

import com.example.EmployeePortal.entity.EmployeeEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomRepo {

    @Autowired
    EntityManager entityManager;

    public List<EmployeeEntity> getByFilter(String sql) {
        Query query = entityManager.createQuery(sql, EmployeeEntity.class);
        return query.getResultList();
    }
}
