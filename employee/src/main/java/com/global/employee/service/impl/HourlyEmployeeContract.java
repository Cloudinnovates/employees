package com.global.employee.service.impl;

import com.global.employee.dto.EmployeeDTO;
import com.global.employee.entity.Employee;
import com.global.employee.service.CalculateEmployeeSalary;

public class HourlyEmployeeContract implements CalculateEmployeeSalary {

	private Employee employee;

	public HourlyEmployeeContract(Employee employee) {
		this.employee = employee;
	}

	@Override
	public EmployeeDTO calculateAnualSalary() {
		EmployeeDTO empl = new EmployeeDTO(employee);
		empl.setAnnualSalary(120 * employee.getHourlySalary() * 12);
		return empl;
	}
}
