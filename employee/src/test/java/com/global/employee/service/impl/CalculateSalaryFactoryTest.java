package com.global.employee.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.global.employee.entity.Employee;
import com.global.employee.enums.TypeOfContract;
import com.global.employee.service.CalculateEmployeeSalary;
import com.global.employee.utils.CreateEntity;

public class CalculateSalaryFactoryTest {

	@Test
	public void testGetHourlyContract() {
		Employee employee = CreateEntity.getEmployee();
		employee.setContractTypeName(TypeOfContract.HOURLY.getContract());
		CalculateEmployeeSalary cal = CalculateSalaryFactory.getEmployeeWithSalaryCalculated(employee);
		assertThat(cal).isNotNull();
		assertThat(cal).isInstanceOf(HourlyEmployeeContract.class);
	}

	@Test
	public void testGetMonthlyContract() {
		Employee employee = CreateEntity.getEmployee();
		employee.setContractTypeName(TypeOfContract.MONTHLY.getContract());
		CalculateEmployeeSalary cal = CalculateSalaryFactory.getEmployeeWithSalaryCalculated(employee);
		assertThat(cal).isNotNull();
		assertThat(cal).isInstanceOf(MonthlyEmployeeContract.class);
	}
	
	@Test
	public void testNullContract() {
		Employee employee = CreateEntity.getEmployee();
		employee.setContractTypeName("Missed");
		CalculateEmployeeSalary cal = CalculateSalaryFactory.getEmployeeWithSalaryCalculated(employee);
		assertThat(cal).isNull();
	}
}
