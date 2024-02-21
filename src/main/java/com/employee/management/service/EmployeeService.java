package com.employee.management.service;

import java.util.List;

import com.employee.management.Excep.BeanNotFoundException;
import com.employee.management.entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	public Employee getEmployee(int id) throws BeanNotFoundException;

	public Employee addEmployee(Employee e) throws BeanNotFoundException;

	public Employee updateEmployee(Employee emp, int id) throws BeanNotFoundException;

	public Integer updateEmployeeStatus(Employee emp, Integer id) throws BeanNotFoundException;

}
