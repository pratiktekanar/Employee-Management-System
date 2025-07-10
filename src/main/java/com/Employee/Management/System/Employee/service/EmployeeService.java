package com.Employee.Management.System.Employee.service;

import com.Employee.Management.System.Employee.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO getEmployeeById(Long id);
    List<EmployeeDTO> getEmployees();

}
