package com.example.samplePro2.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.samplePro2.entities.Employee;
import com.example.samplePro2.repository.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo emprepo;

	String line = "";

	public void saveEmployeeData() throws NumberFormatException, IOException {
		try {
			BufferedReader br = new BufferedReader(new FileReader("/home/swathi/Downloads/employee.csv"));
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				Employee e = new Employee();
				try {
					e.setId(Integer.parseInt(data[0]));
					e.setFirstname(data[1]);
					e.setLastname(data[2]);
					e.setEmail(data[3]);
					e.setAge(Integer.parseInt(data[4]));
					e.setSalary(Integer.parseInt(data[5]));
					e.setMobile((data[6]));
					e.setMobile2((data[7]));
					emprepo.save(e);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// List<Employee> list =new ArrayList<>();
	public Employee getEmployeeById(int id) {
		return emprepo.findById(id).get();
	}

	public Employee postEmployee(Employee emp) {
		try {
			Employee employee = new Employee();
			employee.setId(emp.getId());
			employee.setFirstname(emp.getFirstname());
			employee.setLastname(emp.getLastname());
			employee.setEmail(emp.getEmail());
			employee.setAge(emp.getAge());
			employee.setSalary(emp.getSalary());
			employee.setMobile(emp.getMobile());
			employee.setMobile2(emp.getMobile2());
			emprepo.save(employee);
			return employee;
		} catch (Exception exp) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, " Enter valid Details");

		}

	}

	public List<String> getFullName() {
		List<Employee> emp = emprepo.findAll();
		List<String> list = new ArrayList<>();
		for (var x : emp) {
			list.add(x.getFirstname() + " " + x.getLastname());
		}
		return list;
	}

	public Map<Integer, String> getEmployeeData() {
		Map<Integer, String> map = new HashMap<>();
		List<Employee> emp = emprepo.findAll();
		for (var x : emp) {
			map.put(x.getId(), x.getFirstname());
		}
		return map;
	}

}