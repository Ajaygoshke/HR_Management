package com.Hr_Management.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.Hr_Management.Enum.Role;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(nullable = false, length = 100)
    private String firstName;

    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    private String phone;

    @Column(nullable = false, unique = true)
    private String employeeCode;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private String designation;

    private LocalDate joiningDate;

    private String employmentType;

    private String workLocation;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    private String reportingManager;

    private String employeeStatus;

    private String bloodGroup;

    private String emergencyContactName;

    private String emergencyContactPhone;

    @Column(precision = 12, scale = 2)
    private BigDecimal basicSalary;

    @Column(precision = 12, scale = 2)
    private BigDecimal hra;

    @Column(precision = 12, scale = 2)
    private BigDecimal allowances;

    @Column(precision = 12, scale = 2)
    private BigDecimal deductions;

    @Column(precision = 12, scale = 2)
    private BigDecimal annualCtc;

    private String bankName;

    private String bankAccountNumber;

    private String ifscCode;

    private String pfNumber;

    private String uanNumber;

    private String esiNumber;
 // Salary details
   

    


    

    // PF details

    @Column(precision = 12, scale = 2)
    private BigDecimal pfDeduction;

 
    @Column(precision = 12, scale = 2)
    private BigDecimal esiDeduction;

	private BigDecimal setPfDeduction;

	private BigDecimal setEsiDeduction;

   

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}

	public String getWorkLocation() {
		return workLocation;
	}

	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getReportingManager() {
		return reportingManager;
	}

	public void setReportingManager(String reportingManager) {
		this.reportingManager = reportingManager;
	}

	public String getEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getEmergencyContactName() {
		return emergencyContactName;
	}

	public void setEmergencyContactName(String emergencyContactName) {
		this.emergencyContactName = emergencyContactName;
	}

	public String getEmergencyContactPhone() {
		return emergencyContactPhone;
	}

	public void setEmergencyContactPhone(String emergencyContactPhone) {
		this.emergencyContactPhone = emergencyContactPhone;
	}

	public BigDecimal getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(BigDecimal basicSalary) {
		this.basicSalary = basicSalary;
	}

	public BigDecimal getHra() {
		return hra;
	}

	public void setHra(BigDecimal hra) {
		this.hra = hra;
	}

	public BigDecimal getAllowances() {
		return allowances;
	}

	public void setAllowances(BigDecimal allowances) {
		this.allowances = allowances;
	}

	public BigDecimal getDeductions() {
		return deductions;
	}

	public void setDeductions(BigDecimal deductions) {
		this.deductions = deductions;
	}

	public BigDecimal getAnnualCtc() {
		return annualCtc;
	}

	public void setAnnualCtc(BigDecimal annualCtc) {
		this.annualCtc = annualCtc;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getPfNumber() {
		return pfNumber;
	}

	public void setPfNumber(String pfNumber) {
		this.pfNumber = pfNumber;
	}

	public String getUanNumber() {
		return uanNumber;
	}

	public void setUanNumber(String uanNumber) {
		this.uanNumber = uanNumber;
	}

	public String getEsiNumber() {
		return esiNumber;
	}

	public void setEsiNumber(String esiNumber) {
		this.esiNumber = esiNumber;
	}
	

public static EmployeeBuilder builder() {
    return new EmployeeBuilder();
}

public static class EmployeeBuilder {

    private Long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String employeeCode;
    private String department;
    private String designation;
    private LocalDate joiningDate;
    private String employmentType;
    private String workLocation;
    private Role role;
    private String reportingManager;
    private String employeeStatus;
    private String bloodGroup;
    private String emergencyContactName;
    private String emergencyContactPhone;
    private BigDecimal basicSalary;
    private BigDecimal hra;
    private BigDecimal allowances;
    private BigDecimal deductions;
    private BigDecimal annualCtc;
    private String bankName;
    private String bankAccountNumber;
    private String ifscCode;
    private String pfNumber;
    private String uanNumber;
    private String esiNumber;
	private BigDecimal pfDeduction;
	private BigDecimal esiDeduction;

    public EmployeeBuilder employeeId(Long employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public EmployeeBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public EmployeeBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public EmployeeBuilder email(String email) {
        this.email = email;
        return this;
    }

    public EmployeeBuilder phone(String phone) {
        this.phone = phone;
        return this;
    }

    public EmployeeBuilder employeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
        return this;
    }

    public EmployeeBuilder department(String department) {
        this.department = department;
        return this;
    }

    public EmployeeBuilder designation(String designation) {
        this.designation = designation;
        return this;
    }

    public EmployeeBuilder joiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
        return this;
    }

    public EmployeeBuilder employmentType(String employmentType) {
        this.employmentType = employmentType;
        return this;
    }

    public EmployeeBuilder workLocation(String workLocation) {
        this.workLocation = workLocation;
        return this;
    }

    public EmployeeBuilder role(Role role) {
        this.role = role;
        return this;
    }

    public EmployeeBuilder reportingManager(String reportingManager) {
        this.reportingManager = reportingManager;
        return this;
    }

    public EmployeeBuilder employeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
        return this;
    }

    public EmployeeBuilder bloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
        return this;
    }

    public EmployeeBuilder emergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
        return this;
    }

    public EmployeeBuilder emergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
        return this;
    }

    public EmployeeBuilder basicSalary(BigDecimal basicSalary) {
        this.basicSalary = basicSalary;
        return this;
    }

    public EmployeeBuilder hra(BigDecimal hra) {
        this.hra = hra;
        return this;
    }

    public EmployeeBuilder allowances(BigDecimal allowances) {
        this.allowances = allowances;
        return this;
    }

    public EmployeeBuilder deductions(BigDecimal deductions) {
        this.deductions = deductions;
        return this;
    }

    public EmployeeBuilder annualCtc(BigDecimal annualCtc) {
        this.annualCtc = annualCtc;
        return this;
    }

    public EmployeeBuilder bankName(String bankName) {
        this.bankName = bankName;
        return this;
    }

    public EmployeeBuilder bankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
        return this;
    }

    public EmployeeBuilder ifscCode(String ifscCode) {
        this.ifscCode = ifscCode;
        return this;
    }

    public EmployeeBuilder pfNumber(String pfNumber) {
        this.pfNumber = pfNumber;
        return this;
    }

    public EmployeeBuilder uanNumber(String uanNumber) {
        this.uanNumber = uanNumber;
        return this;
    }

    public EmployeeBuilder esiNumber(String esiNumber) {
        this.esiNumber = esiNumber;
        return this;
    }
    public EmployeeBuilder pfDeduction(BigDecimal pfDeduction) {
        this.pfDeduction = pfDeduction;
        return this;
    }

    public EmployeeBuilder esiDeduction(BigDecimal esiDeduction) {
        this.esiDeduction = esiDeduction;
        return this;
    }
    public Employee build() {
        Employee employee = new Employee();

        employee.setEmployeeId(employeeId);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setEmail(email);
        employee.setPhone(phone);
        employee.setEmployeeCode(employeeCode);
        employee.setDepartment(department);
        employee.setDesignation(designation);
        employee.setJoiningDate(joiningDate);
        employee.setEmploymentType(employmentType);
        employee.setWorkLocation(workLocation);
        employee.setRole(role);
        employee.setReportingManager(reportingManager);
        employee.setEmployeeStatus(employeeStatus);
        employee.setBloodGroup(bloodGroup);
        employee.setEmergencyContactName(emergencyContactName);
        employee.setEmergencyContactPhone(emergencyContactPhone);
        employee.setBasicSalary(basicSalary);
        employee.setHra(hra);
        employee.setAllowances(allowances);
        employee.setDeductions(deductions);
        employee.setAnnualCtc(annualCtc);
        employee.setBankName(bankName);
        employee.setBankAccountNumber(bankAccountNumber);
        employee.setIfscCode(ifscCode);
        employee.setPfNumber(pfNumber);
        employee.setUanNumber(uanNumber);
        employee.setEsiNumber(esiNumber);
        employee.setPfDeduction(pfDeduction);
        employee.setEsiDeduction(esiDeduction);
        return employee;
    }
}






	
}