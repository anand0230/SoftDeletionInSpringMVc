package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.IEmployeeService;

@Controller
@RequestMapping("/employee_con")
public class EmployeeOperationController {
	
	@Autowired
	private IEmployeeService ies;
	
	
	
	//home page
	@GetMapping("/")
	public  String home() {
		System.out.println("EmployeeOperationController.home()");
		return "home";
	}
	
       //all the data of employee        
	@GetMapping("/report")
	public  String showAllEmployee(Map<String,Object> m) {
		System.out.println("EmployeeOperationController.showAllEmployee()");
		
		
		m.put("emplist", ies.findAllEmployee());
		
		return "show_employee";
	}
	
	//after clicking in addemployee button
	@GetMapping("/register")
	public  String addEmployee(@ModelAttribute("emp")Employee e) {
 
		System.out.println("EmployeeOperationController.addEmployee()");
		
		
		return "show_form";
	}
	
	
	///adding the employee and returning the message
	
	@PostMapping("/register")
	public String registerEmployee(@ModelAttribute("emp") Employee e,
			Map<String, Object> m,RedirectAttributes rtt /*,HttpSession ses*/) {
		
     System.out.println("EmployeeOperationController.registerEmployee()");
    // m.put("msg", ies.addEmployee(e));
	// m.put("emplist", ies.findAllEmployee());
  
    rtt.addFlashAttribute("msg",ies.addEmployee(e));//this will give the message to redirect handler method only for one time and after it will destroy
   // ses.setAttribute("msg", ies.addEmployee(e));
    
		//return "redirect:report";//here redirect report will work properly but we did not get msg related to saved employee
    // return "redirect:report";//for solving above problem we need RedirectAttribute Object FlashAttribute but here one limitation is there after clicking on refresh button the msg will not show
     return "redirect:report";//if we want after redirect aslo message will come then in this situation we need to use session attribute but flashattribute is recommaded
	}
	
	
	//after clicking in edit button
	@GetMapping("/edit")
	public String editEmployee(@RequestParam int no,@ModelAttribute("emp") Employee emp) {
		
		System.out.println("EmployeeOperationController.editEmployee()");
	Employee emp1=ies.findEmpById(no);
	BeanUtils.copyProperties(emp1, emp);
		
		return "display_form";		
	}
	
	
	//after getting data from form we need to update the data in db table
	@PostMapping("/edit")
	public String updateEmployee(@ModelAttribute("emp") Employee emp,RedirectAttributes rda) {
		
		System.out.println("EmployeeOperationController.updateEmployee()");
		
	    rda.addFlashAttribute("msg",ies.updateEmployee(emp));
	    
		return "redirect:report";		
	}
	
	//delete employee details
	@GetMapping("/delete")
	public String deleteEmloyee(@RequestParam int no ,RedirectAttributes rda) {
		
		System.out.println("EmployeeOperationController.deleteEmloyee()");
		rda.addFlashAttribute("msg",ies.deleteEmployee(no));
		
		return "redirect:report";
	}
	
	

	
	
	
}
