package com.global.employee.repository;

import java.util.List;

import com.global.employee.entity.Employee;

public interface EmployeeRepository {

	List<Employee> getEmployees();
}
