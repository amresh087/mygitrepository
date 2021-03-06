package com.amresh.spring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amresh.spring.model.Employee;

/**
 * Handles requests for the Employee service.
 */

@RestController
@RequestMapping("/rest")
public class EmployeeController {
	
	@Autowired
	private Employee emp;

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	// Map to store employees, ideally we should use database
	Map<Integer, Employee> empData = new HashMap<Integer, Employee>();

	@RequestMapping(value = "/emp/dummy", method = RequestMethod.GET)
	public  Employee getDummyEmployee() {
		logger.info("Start getDummyEmployee");
		emp.setId(9999);
		emp.setName("Dummy");
		emp.setCreatedDate(new Date());
		empData.put(9999, emp);
		return emp;
	}

	@RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
	public  Employee getEmployee(@PathVariable("id") int empId) {
		logger.info("Start getEmployee. ID=" + empId);

		return empData.get(empId);
	}

	@RequestMapping(value = "/emps", method = RequestMethod.GET)
	public  List<Employee> getAllEmployees() {
		logger.info("Start getAllEmployees.");
		List<Employee> emps = new ArrayList<Employee>();
		Set<Integer> empIdKeys = empData.keySet();
		for (Integer i : empIdKeys) {
			emps.add(empData.get(i));
		}
		return emps;
	}

	@RequestMapping(value = "/emp/create", method = RequestMethod.POST)
	public  Employee createEmployee(@RequestBody Employee emp) {
		logger.info("Start create Employee.");
		emp.setCreatedDate(new Date());
		empData.put(emp.getId(), emp);
		return emp;
	}

	@RequestMapping(value = "/emp/update/{id}", method = RequestMethod.PUT)
	public  Employee updateEmployee(@PathVariable("id") int empId) {
		logger.info("Start update Employee.");
		Employee emp = empData.get(empId);
		empData.remove(empId);
		return emp;
	}
	
	
	@RequestMapping(value = "/emp/delete/{id}", method = RequestMethod.DELETE)
	public  Employee deleteEmployee(@PathVariable("id") int empId) {
		logger.info("Start delete Employee.");
		Employee emp = empData.get(empId);
		empData.remove(empId);
		return emp;
	}

}
