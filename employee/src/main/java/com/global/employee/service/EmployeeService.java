package com.global.employee.service;

import java.util.List;

import com.global.employee.dto.EmployeeDTO;

public interface EmployeeService {
	
	List<EmployeeDTO> getEmployees(Integer employeeId);
}
