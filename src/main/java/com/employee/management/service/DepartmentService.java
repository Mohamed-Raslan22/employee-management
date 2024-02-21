package com.employee.management.service;

import java.util.List;

import com.employee.management.Excep.BeanNotFoundException;
import com.employee.management.entity.Department;

public interface DepartmentService {

	public List<Department> getAllDepartments();

	public Department getDepartment(int id) throws BeanNotFoundException;

	public Department addDepartment(Department d);

}
