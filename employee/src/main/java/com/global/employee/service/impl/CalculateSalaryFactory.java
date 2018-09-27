package com.global.employee.service.impl;

import com.global.employee.entity.Employee;
import com.global.employee.enums.TypeOfContract;
import com.global.employee.service.CalculateEmployeeSalary;

public class CalculateSalaryFactory {

	public static CalculateEmployeeSalary getEmployeeWithSalaryCalculated(Employee employee) {
		if (employee != null) {
			switch (TypeOfContract.fromString(employee.getContractTypeName())) {
			case HOURLY:
				return new HourlyEmployeeContract(employee);
			case MONTHLY:
				return new MonthlyEmployeeContract(employee);
			case NON_EXISTENT:
				return null;
			}
		}
		return null;
	}
}
