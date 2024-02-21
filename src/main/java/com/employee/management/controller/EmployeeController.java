package com.employee.management.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.Excep.BeanNotFoundException;
import com.employee.management.dto.ErrorResponse;
import com.employee.management.dto.ResponseE;
import com.employee.management.dto.SuccessResponse;
import com.employee.management.entity.Employee;
import com.employee.management.impl.EmployeeServiceImple;

@RestController
public class EmployeeController {

	static final Logger logger = LogManager.getLogger(EmployeeController.class.getName());

	@Autowired
	private EmployeeServiceImple employeeService;

	@GetMapping("/employees")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable int id) throws BeanNotFoundException {
		return employeeService.getEmployee(id);
	}

	@PostMapping("/employees")
	public ResponseEntity<Employee> addEmployees(@RequestBody Employee employee) throws BeanNotFoundException {
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.addEmployee(employee));
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee e,
			@PathVariable int id /* I have passed it for more validation only */) throws BeanNotFoundException {
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.updateEmployee(e, id));

	}

	@PatchMapping("employees/{id}")
	public ResponseEntity<ResponseE> updateEmployeeStsatus(@RequestBody Employee e, @PathVariable Integer id) throws BeanNotFoundException {
		
		if (employeeService.updateEmployeeStatus(e, id) == 1) {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(new SuccessResponse(HttpStatus.CREATED.value(), "the Update Succeed :", LocalDateTime.now()));
		}else {
			return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT)
					.body(new ErrorResponse(HttpStatus.REQUEST_TIMEOUT.value(), "Please check the logs and DB as There is a failed Thing during processing", LocalDateTime.now()));

		}
		

	}

}
