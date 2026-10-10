package com.Hr_Management.dto;

import java.time.LocalDate;

import com.Hr_Management.Enum.Role;

public record EmployeeResponse(
        Long employeeId,
        String employeeCode,
        String firstName,
        String lastName,
        String email,
        String department,
        String designation,
        LocalDate joiningDate,
        Role role,
        String employeeStatus
) {
}