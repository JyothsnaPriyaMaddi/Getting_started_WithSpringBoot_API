package com.jyo.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	List<Employee> employeeList = new ArrayList<>(Arrays.asList(
			new Employee(1, "Jyothsna Priya", "Canada"),
			new Employee(2, "Jhansi", "New York"),
			new Employee(3, "Yamini", "Australia")
		));
	//get
	public List<Employee> getAllEmployees() {
		return employeeList;
	}
	
	//delete
	public List<Employee> deleteEmployee(int id) {
		List<Employee> tempEmployeeList = new ArrayList<>();
		for(Employee emp : employeeList) {
			if(emp.getEmployeeId() == id ) {
				continue;
			}
			tempEmployeeList.add(emp);
		}
		this.employeeList = tempEmployeeList;
		return employeeList;
	}
	
	//update
	public void updateEmployee(Employee employee) {
        List<Employee> tempEmployee = new ArrayList<>();
        for(Employee emp : employeeList) {
            if(emp.getEmployeeId() == employee.getEmployeeId()) {
                emp.setEmployeeName(employee.getEmployeeName());
                emp.setEmployeeCity(employee.getEmployeeCity());
            }
            tempEmployee.add(emp);
        }
        this.employeeList = tempEmployee;
    }
	
	//CREATE
	public List<Employee> createEmployee(Employee employee) {
		employeeList.add(employee);
		return employeeList;
	}
}
