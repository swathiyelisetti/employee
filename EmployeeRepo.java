package com.example.samplePro2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.samplePro2.entities.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer>{

}
