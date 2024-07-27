package com.nt.service;

import com.nt.model.Employee;

public interface IEmployeeService {
	
	public Iterable<Employee> findAllEmployee();
	public String addEmployee(Employee emp);
	public Employee findEmpById(Integer empno);
	public String updateEmployee(Employee emp);
	public String deleteEmployee(Integer empno);
	

}
