package com.employee.management.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.management.Excep.BeanNotFoundException;
import com.employee.management.entity.Department;
import com.employee.management.repository.DepartmentRepository;
import com.employee.management.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public List<Department> getAllDepartments() {
		return (List<Department>) Optional.ofNullable(departmentRepository.findAll()).orElse(Collections.emptyList());
	}

	@Override
	public Department getDepartment(int id) throws BeanNotFoundException {
		Optional<Department> departmentOptional = Optional.ofNullable(departmentRepository.findOne(id));

		return departmentOptional.orElseThrow(() -> new BeanNotFoundException("Department not found with id: " + id));

	}

	@Override
	public Department addDepartment(Department d) {
		return departmentRepository.save(d);

	}

}
