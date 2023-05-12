package com.example.samplePro2.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.samplePro2.entities.Employee;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService es;

	@PostMapping("/postEmployees")
//	@RequestMapping(path="/employeeData")
	public void setDataInDataBase() throws NumberFormatException, IOException {
		es.saveEmployeeData();
	}

	@GetMapping("/getemployees/{id}")
	public Employee getEmployeeById(@PathVariable int id) {

		return es.getEmployeeById(id);

	}

	@PostMapping("/InsertEmployee")
	public void postEmployees(@RequestBody Employee employee) {
		es.postEmployee(employee);
	}
	
	@GetMapping("/getEmployeesWithFirstnameAndLastName")
	   public List<String> name() {
		 return es.getFullName();
	}
	
	@GetMapping("/getEmployeeDataUsingMap")
	public Map<Integer, String> getEmployeeData() {
		return es.getEmployeeData();
	}
	

}
