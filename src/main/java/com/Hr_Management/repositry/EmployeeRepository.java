package com.Hr_Management.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Hr_Management.model.Employee;

public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {

    boolean existsByEmail(String email);

    boolean existsByEmployeeCode(String employeeCode);
}