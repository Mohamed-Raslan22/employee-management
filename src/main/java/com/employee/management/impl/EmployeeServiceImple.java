package com.employee.management.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.management.Excep.BadRequestException;
import com.employee.management.Excep.BeanNotFoundException;
import com.employee.management.entity.Department;
import com.employee.management.entity.Employee;
import com.employee.management.repository.DepartmentRepository;
import com.employee.management.repository.EmployeeRepository;
import com.employee.management.service.EmployeeService;

@Service
public class EmployeeServiceImple implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private DepartmentRepository dep;

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> emps = (List<Employee>) employeeRepository.findAll();
		return emps;
	}

	@Override
	public Employee getEmployee(int id) throws BeanNotFoundException {

		Optional<Employee> employeeOptional = Optional.ofNullable(employeeRepository.findOne(id));

		return employeeOptional.orElseThrow(() -> new BeanNotFoundException("This Employee does not Exist : -> " + id));

	}

	@Override
	public Employee addEmployee(Employee e) throws BeanNotFoundException {

		if (null == e.getDepartment() || null == e.getDepartment().getDepartmentId())
			throw new BadRequestException("Invalid request please make sure you have passed Department ");

		Optional<Department> departmentOptional = Optional.ofNullable(dep.findOne(e.getDepartment().getDepartmentId()));

		Department department = departmentOptional.orElseThrow(() -> new BeanNotFoundException(
				"Department not found with id: " + e.getDepartment().getDepartmentId()));

		e.setDepartment(department);
		return employeeRepository.save(e);
	}

	@Override
	public Employee updateEmployee(Employee emp, int id) throws BeanNotFoundException {

		if (null == emp.getEmployeeID() || id != emp.getEmployeeID())
			throw new BadRequestException(
					"Invalid request please make sure you have passed correct employeeId or the iDs is  Matching each other ");
		
		Employee currentEmployee = employeeRepository.findOne(id);

		if (null == currentEmployee)
			throw new BeanNotFoundException("This Employee does not exist please check the employee ID ");
		
		return employeeRepository.save(emp);

	}

	@Override
	public Integer updateEmployeeStatus(Employee emp, Integer id) throws BeanNotFoundException {

		if (null == emp.getEmployeeID() || id != emp.getEmployeeID())
			throw new BadRequestException(
					"Invalid request please make sure you have passed correct employeeId or the iDs is  Matching each other ");
		
		if (null == employeeRepository.findOne(id))
			throw new BeanNotFoundException("This Employee does not exist please check the employee ID ");

		if (null == emp.getStatus()) {
			throw new BadRequestException(
					"Invalid request please make sure you have passed the Status of The Employee ");
		} else {

			return employeeRepository.updateEmployeeStatus(id, emp.getStatus());

		}

	}

	

}
