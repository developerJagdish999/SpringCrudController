
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

    // Open employee registration form
    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "register";   // register.html
    }

    // Save employee
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee) {
        empService.saveEmployee(employee);
        return "redirect:/employees/new"; // redirect back to form
    }

}