package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.model.Employee;

@Controller
@RequestMapping("employee")
public class EmployeeController {
	
	@Autowired
	EmployeeDao empDao;
	
	@RequestMapping("")
	public String getAll(Model model) {
		List<Employee> employees = empDao.getAll();
		model.addAttribute("data", employees);
		return "employees";
	}
	
	@RequestMapping("/{employeeId}")
	public String detail(@PathVariable("employeeId")int employeeId, Model model) {
		Employee employee = empDao.getOne(employeeId);
		model.addAttribute("employee", employee);
		return "detail";
	}
	
	@RequestMapping("add")
	public String formAdd(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "formAdd";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String insertEmployee(@ModelAttribute Employee employee, Model model) {
		empDao.insert(employee);
		System.out.println(employee.getFirstName());
		return "redirect: /employee";
	}
}
