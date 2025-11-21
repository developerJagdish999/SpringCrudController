//package com.example.demomvcproject.services;
//
//import org.springframework.stereotype.Service;
//
//@Service
//public class EmpService {
//create
//	//all employee reads
//	//update
//	
//}
package com.example.demo.mvcproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.mvcproject.entity.Employee;
import com.example.demo.mvcproject.repository.EmployeeRepository;

@Service
public class EmpService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // ✅ Create or Update Employee
    public void saveEmployee(Employee emp) {
        employeeRepository.save(emp);
    }

    // ✅ Fetch all employees
    public java.util.List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // ✅ Fetch employee by ID
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    // ✅ Delete employee
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
}
