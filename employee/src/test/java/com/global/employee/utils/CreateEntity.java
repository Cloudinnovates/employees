package com.global.employee.utils;

import com.global.employee.entity.Employee;

public class CreateEntity {

	public static Employee getEmployee() {
		return new Employee(1, "Karl", "HourlySalaryEmployee", 2, "Administrator", null, 20.0, 10.0);
	}
}
