package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.repository.IEmployeeRepo;
@Service
public class EmployeeService implements IEmployeeService{
	
	@Autowired
	private IEmployeeRepo ier;

	@Override
	public Iterable<Employee> findAllEmployee() {
		//return all present employee from the table
		System.out.println("EmployeeService.findAllEmployee()");
		return ier.findAll();
	}

	@Override
	public String addEmployee(Employee emp) {
		System.out.println("EmployeeService.addEmployee()");
		int empno=ier.save(emp).getEmpno();
		return "Employee Added With The EmpNo "+empno;
	}

	@Override
	public Employee findEmpById(Integer empno) {
		System.out.println("EmployeeService.findEmpById()");
		Optional<Employee> emp=ier.findById(empno);
		
			return emp.orElseThrow(()->new IllegalArgumentException("Employee is not present?"));
		
	}

	@Override
	public String updateEmployee(Employee emp) {
		System.out.println("EmployeeService.updateEmployee()");
		Optional<Employee> emp1=ier.findById(emp.getEmpno());
		if(emp1.isPresent()) {
			return ier.save(emp).getEname()+ " Details Updated";	
		}
		
		return " Some Error";
	}

	//delete employee
	@Override
	public String deleteEmployee(Integer empno) {
		System.out.println("EmployeeService.deleteEmployee()");
		Optional<Employee> emp1=ier.findById(empno);
		if(emp1.isPresent()) {
			
			ier.deleteById(empno);
			return  "Employee No " +empno+ " Record is deleted";	
		}
		return empno+" no Employee not found";
	}
	

}
