package com.global.employee.service.impl;

import com.global.employee.dto.EmployeeDTO;
import com.global.employee.entity.Employee;
import com.global.employee.service.CalculateEmployeeSalary;

public class MonthlyEmployeeContract implements CalculateEmployeeSalary {

	private Employee employee;

	public MonthlyEmployeeContract(Employee employee) {
		this.employee = employee;
	}

	@Override
	public EmployeeDTO calculateAnualSalary() {
		EmployeeDTO empl = new EmployeeDTO(employee);
		empl.setAnnualSalary(employee.getMonthlySalary() * 12);
		return empl;
	}

}
