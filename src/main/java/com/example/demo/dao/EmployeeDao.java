package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@Repository
public interface EmployeeDao {
	public List<Employee> getAll();
	public Employee getOne(int employeeId);
	public void insert(Employee employee);
	public void update(Employee employee);
	public void delete(int employeeId);
}
