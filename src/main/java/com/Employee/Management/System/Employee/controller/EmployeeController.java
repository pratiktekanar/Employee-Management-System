package com.Employee.Management.System.Employee.controller;

import com.Employee.Management.System.Employee.dto.EmployeeDTO;
import com.Employee.Management.System.Employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

//   Build Add Employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO savedEmployee = employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>(savedEmployee , HttpStatus.CREATED);
    }

//    Get Employee by id
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.getEmployeeById(id) , HttpStatus.OK);
    }

//    Get All Employee
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getEmployees(){
        List<EmployeeDTO> employees = employeeService.getEmployees();
        return new ResponseEntity<>(employees , HttpStatus.OK);
    }

//    Update Employee
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long id,@RequestBody EmployeeDTO updatedEmployee){
        return new ResponseEntity<>(employeeService.updateEmployee(id,updatedEmployee) , HttpStatus.OK);
    }

//    Employee delete by id
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }

}
