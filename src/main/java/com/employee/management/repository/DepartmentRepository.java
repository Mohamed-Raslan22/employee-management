package com.employee.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.employee.management.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	

}
