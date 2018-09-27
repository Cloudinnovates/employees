package com.global.employee.dto;

import com.global.employee.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class EmployeeDTO {

	private int id;
	private String name;
	private String contractTypeName;
	private Integer roleId;
	private String roleName;
	private Object roleDescription;
	private Double hourlySalary;
	private Double monthlySalary;
	private Double annualSalary;

	public EmployeeDTO(Employee employee) {
		this.id = employee.getId();
		this.name = employee.getName();
		this.contractTypeName = employee.getContractTypeName();
		this.roleId = employee.getRoleId();
		this.roleName = employee.getRoleName();
		this.roleDescription = employee.getRoleDescription();
		this.hourlySalary = employee.getHourlySalary();
		this.monthlySalary = employee.getMonthlySalary();
	}
}
