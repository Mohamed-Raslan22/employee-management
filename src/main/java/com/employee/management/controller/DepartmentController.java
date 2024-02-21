package com.employee.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.Excep.BeanNotFoundException;
import com.employee.management.entity.Department;
import com.employee.management.impl.DepartmentServiceImpl;

@RestController
public class DepartmentController {


	@Autowired
	private DepartmentServiceImpl departmentService;

	@GetMapping("/departments")
	public List<Department> getAllDepartment() {
		return departmentService.getAllDepartments();
	}

	@GetMapping("/departments/{id}")
	public Department getDepartment(@PathVariable int id) throws BeanNotFoundException {
		return departmentService.getDepartment(id);
	}

	@PostMapping("/departments")
	public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
		return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.addDepartment(department));
	}

}
