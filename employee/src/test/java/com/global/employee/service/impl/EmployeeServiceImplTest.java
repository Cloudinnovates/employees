package com.global.employee.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.global.employee.dto.EmployeeDTO;
import com.global.employee.entity.Employee;
import com.global.employee.enums.TypeOfContract;
import com.global.employee.repository.EmployeeRepository;
import com.global.employee.service.EmployeeService;
import com.global.employee.utils.CreateEntity;

@RunWith(SpringRunner.class)
public class EmployeeServiceImplTest {

	private EmployeeService employeeService;

	@Mock
	private EmployeeRepository employeeRepository;
	
	private List<Employee> employees;

	@Before
	public void init() {
		Employee empl1 = CreateEntity.getEmployee();
		empl1.setId(1);
		empl1.setContractTypeName(TypeOfContract.HOURLY.getContract());
		Employee empl2 = CreateEntity.getEmployee();
		empl2.setId(2);
		empl2.setContractTypeName(TypeOfContract.MONTHLY.getContract());
		Employee empl3 = CreateEntity.getEmployee();
		empl3.setId(3);
		empl3.setContractTypeName("AnyContract");

		employees = new ArrayList<>();
		employees.add(empl1);
		employees.add(empl2);
		employees.add(empl3);

		when(employeeRepository.getEmployees()).thenReturn(employees);
		employeeService = new EmployeeServiceImpl(employeeRepository);
	}

	@Test
	public void testGetEmployees() {
		List<EmployeeDTO> employees = employeeService.getEmployees(null);
		assertThat(employees).isNotNull();
		assertThat(employees).size().isEqualTo(3);
	}

	@Test
	public void testGetEmployeeWithContract() {
		List<EmployeeDTO> employee = employeeService.getEmployees(1);
		assertThat(employees).isNotNull();
		assertThat(employee).size().isEqualTo(1);
		assertThat(employee.get(0).getAnnualSalary()).isGreaterThan(0);
	}
	
	@Test
	public void testGetEmployeeWithoutContract() {
		List<EmployeeDTO> employee = employeeService.getEmployees(3);
		assertThat(employees).isNotNull();
		assertThat(employee).size().isEqualTo(1);
		assertThat(employee.get(0).getAnnualSalary()).isNull();
	}

}
