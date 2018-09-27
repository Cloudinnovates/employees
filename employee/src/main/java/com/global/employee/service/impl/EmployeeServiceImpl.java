package com.global.employee.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.employee.dto.EmployeeDTO;
import com.global.employee.entity.Employee;
import com.global.employee.repository.EmployeeRepository;
import com.global.employee.service.CalculateEmployeeSalary;
import com.global.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<EmployeeDTO> getEmployees(Integer employeeId) {
		List<Employee> employees = employeeRepository.getEmployees();
		if (!employees.isEmpty()) {
			return employees.stream().filter(emp ->{
				if(employeeId != null) {
					return emp.getId().equals(employeeId);
				}
				return true;
			})
					.map(empMap -> getEmployeeDTOWithAnualSalary(empMap)).collect(Collectors.toList());
		}
		return Collections.emptyList();
	}

	private EmployeeDTO getEmployeeDTOWithAnualSalary(Employee employee) {
		CalculateEmployeeSalary cal = CalculateSalaryFactory.getEmployeeWithSalaryCalculated(employee);
		if (cal != null) {
			return cal.calculateAnualSalary();
		}
		return new EmployeeDTO(employee);
	}

}
