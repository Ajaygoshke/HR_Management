package com.Hr_Management.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.Hr_Management.Enum.Role;
import com.Hr_Management.dto.EmployeeRequest;
import com.Hr_Management.dto.EmployeeResponse;
import com.Hr_Management.model.Employee;
import com.Hr_Management.repositry.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    

    @Transactional
    public EmployeeResponse createEmployee(EmployeeRequest request) {

        if (employeeRepository.existsByEmail(request.getEmail())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Email already exists"
            );
        }

        if (employeeRepository.existsByEmployeeCode(
                request.getEmployeeCode())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Employee code already exists"
            );
        }

        // Do not allow the employee-creation endpoint
        // to create another administrator account.
        if (request.getRole() == Role.ADMIN) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Cannot assign ADMIN role through employee creation"
            );
        }

        Employee employee = Employee.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .employeeCode(request.getEmployeeCode())
                .department(request.getDepartment())
                .designation(request.getDesignation())
                .joiningDate(request.getJoiningDate())
                .employmentType(request.getEmploymentType())
                .workLocation(request.getWorkLocation())
                .role(request.getRole())
                .reportingManager(request.getReportingManager())
                .employeeStatus("ACTIVE")
                .bloodGroup(request.getBloodGroup())
                .emergencyContactName(
                        request.getEmergencyContactName())
                .emergencyContactPhone(
                        request.getEmergencyContactPhone())
                .basicSalary(request.getBasicSalary())
                .hra(request.getHra())
                .allowances(request.getAllowances())
                .deductions(request.getDeductions())
                .annualCtc(request.getAnnualCtc())
                .bankName(request.getBankName())
                .bankAccountNumber(request.getBankAccountNumber())
                .ifscCode(request.getIfscCode())
                .pfNumber(request.getPfNumber())
                .uanNumber(request.getUanNumber())
                .esiNumber(request.getEsiNumber())
                .build();

        Employee saved = employeeRepository.save(employee);

        return new EmployeeResponse(
                saved.getEmployeeId(),
                saved.getEmployeeCode(),
                saved.getFirstName(),
                saved.getLastName(),
                saved.getEmail(),
                saved.getDepartment(),
                saved.getDesignation(),
                saved.getJoiningDate(),
                saved.getRole(),
                saved.getEmployeeStatus()
        );
    }
}