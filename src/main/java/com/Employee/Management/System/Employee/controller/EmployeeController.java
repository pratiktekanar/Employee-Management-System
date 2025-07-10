package com.Employee.Management.System.Employee.controller;

import com.Employee.Management.System.Employee.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeRepository employeeRepository;

//   Build Add Employee REST API

}
