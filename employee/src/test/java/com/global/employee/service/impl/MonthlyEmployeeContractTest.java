package com.global.employee.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.global.employee.dto.EmployeeDTO;
import com.global.employee.entity.Employee;
import com.global.employee.service.CalculateEmployeeSalary;
import com.global.employee.utils.CreateEntity;

public class MonthlyEmployeeContractTest {

	@Test
	public void testCalculateAnualSalary() {
		Double expectedSalary = 84.0;
		Employee employee = CreateEntity.getEmployee();
		employee.setMonthlySalary(7.0);
		CalculateEmployeeSalary monthlyEmployeeContract = new MonthlyEmployeeContract(employee);
		EmployeeDTO employeeDTOactual = monthlyEmployeeContract.calculateAnualSalary();
		assertThat(employeeDTOactual).isNotNull();
		assertThat(employeeDTOactual.getAnnualSalary()).isEqualTo(expectedSalary);
	}
}
