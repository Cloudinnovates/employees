package com.global.employee.entity;

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
public class Employee {

	private Integer id;
	private String name;
	private String contractTypeName;
	private Integer roleId;
	private String roleName;
	private Object roleDescription;
	private Double hourlySalary;
	private Double monthlySalary;
}
