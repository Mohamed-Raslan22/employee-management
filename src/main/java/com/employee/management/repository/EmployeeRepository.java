package com.employee.management.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employee.management.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Transactional
	@Modifying
	@Query(value = "UPDATE Employee e SET e.status = :newStatus WHERE e.employee_id = :employeeId", nativeQuery = true)
	public Integer updateEmployeeStatus(@Param("employeeId") Integer employeeId, @Param("newStatus") String newStatus);

}
