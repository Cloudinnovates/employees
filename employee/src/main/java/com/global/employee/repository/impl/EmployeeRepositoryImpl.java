package com.global.employee.repository.impl;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.global.employee.entity.Employee;
import com.global.employee.repository.EmployeeRepository;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRepositoryImpl.class);
	private final RestTemplate restTemplate = new RestTemplate();
	
	@Value("${url.masglobal}")
	private String repository;

	public List<Employee> getEmployees() {
		List<Employee> employees = Collections.emptyList();
		try {
			ResponseEntity<List<Employee>> response = restTemplate.exchange(
					  repository,
					  HttpMethod.GET,
					  null,
					  new ParameterizedTypeReference<List<Employee>>(){});
			employees = response.getBody();
		} catch (HttpClientErrorException | ResourceAccessException | IllegalStateException e) {
			LOGGER.error("It could not connect to masglobal API", e);
		}
		return employees;
	}
}
