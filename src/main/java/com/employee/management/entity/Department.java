package com.employee.management.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="department")
public class Department {

	@Id
	@Column(name="department_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer departmentId;
	
	@Column(name="abbreviation_name")
	private String abbreviationName;
	
	@Column(name="department_name")
	private String departmentName;
	
	@JsonIgnore
	@OneToMany(mappedBy="department" , cascade=CascadeType.ALL)
	private Set<Employee> employees;
	
	public Department() {
	
	}
	
	public Department(Integer departmentID){
		this.departmentId = departmentID;
	}
	
	public Department(Integer departmentID, String short_Name, String department_Name, Set<Employee> employees) {
		this.departmentId = departmentID;
		this.abbreviationName = short_Name;
		this.departmentName = department_Name;
		this.employees = employees;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", abbreviationName=" + abbreviationName
				+ ", departmentName=" + departmentName + ", employees=" + employees + "]";
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getAbbreviationName() {
		return abbreviationName;
	}

	public void setAbbreviationName(String abbreviationName) {
		this.abbreviationName = abbreviationName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}
