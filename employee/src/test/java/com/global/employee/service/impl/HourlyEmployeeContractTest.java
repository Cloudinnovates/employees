package com.global.employee.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.global.employee.dto.EmployeeDTO;
import com.global.employee.entity.Employee;
import com.global.employee.service.CalculateEmployeeSalary;
import com.global.employee.utils.CreateEntity;

public class HourlyEmployeeContractTest {

	@Test
	public void testCalculateAnualSalary() {
		Double expectedSalary = 2880.0;
		Employee employee = CreateEntity.getEmployee();
		employee.setHourlySalary(2.0);
		CalculateEmployeeSalary hourlyEmployeeContract = new HourlyEmployeeContract(employee);
		EmployeeDTO employeeDTOactual = hourlyEmployeeContract.calculateAnualSalary();
		assertThat(employeeDTOactual).isNotNull();
		assertThat(employeeDTOactual.getAnnualSalary()).isEqualTo(expectedSalary);
	}
}
