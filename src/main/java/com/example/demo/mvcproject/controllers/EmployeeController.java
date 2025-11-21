//package com.example.demo.mvcproject.controllers;
//
//
//	import java.util.HashMap;
//	import java.util.Map;
//	
//	import org.springframework.web.bind.annotation.GetMapping;
//	import org.springframework.web.bind.annotation.RestController;
//	import org.springframework.web.servlet.ModelAndView;
//	
//	@RestController
//	public class EmployeeController {
//		@GetMapping("/getForm")
//	public ModelAndView getRegistrationForm() {
//			String ViewName ="register";
//		Map<String,Object> model = new HashMap<>();
//		model.put("DisplayTheName", "jagdish");
//		return new ModelAndView(ViewName,model);
//	}
//	}
package com.example.demo.mvcproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.mvcproject.entity.Employee;
import com.example.demo.mvcproject.services.EmpService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmpService empService;

    // Show the form
 // Handle any wrong GET requests to /employees/save/**
    @GetMapping("/save/**")
    public String handleWrongSaveUrl() {
        return "redirect:/employees/new";
    }

    // Handle form submission
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee, Model model) {
        empService.saveEmployee(employee);
        model.addAttribute("message", "Employee saved successfully!");
        return "success";  // Redirect to success.html or same form
    }
}

