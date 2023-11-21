package com.jyo.sample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	//GET REQUEST
	@RequestMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	
	//DELETE REQUEST
	@DeleteMapping("/employees/{id}")
	public List<Employee> deleteAnEmployee(@PathVariable int id) {
		return employeeService.deleteEmployee(id);
	}
	
	//UPDATE REQUEST
	@RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
    public void updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
    }
	
	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	public List<Employee> createEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}
	
}
