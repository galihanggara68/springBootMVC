package com.example.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Employee;
import com.example.demo.util.Connector;

@Component
public class EmployeeDaoImpl implements EmployeeDao{
	
	@Autowired
	Connection con;
	
	@Override
	public List<Employee> getAll() {
		List<Employee> result = new ArrayList<Employee>();
		try {
			Statement stmt = con.createStatement();
			String query = "select employee_id, first_name, last_name from copy_employees";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt(1));
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
				result.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Employee getOne(int employeeId) {
		Employee result = new Employee();
		try {
			Statement stmt = con.createStatement();
			String query = "select employee_id, first_name, last_name from copy_employees where employee_id="+employeeId;
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			result.setEmployeeId(rs.getInt(1));
			result.setFirstName(rs.getString(2));
			result.setLastName(rs.getString(3));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void insert(Employee employee) {
		try {
			String query = "insert into copy_employees(employee_id, first_name, last_name) values(?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, employee.getEmployeeId());
			stmt.setString(2, employee.getFirstName());
			stmt.setString(3, employee.getLastName());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int employeeId) {
		// TODO Auto-generated method stub
		
	}
	
}
