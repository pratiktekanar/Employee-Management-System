package com.Employee.Management.System.Employee.service.EmployeeServiceImp;

import com.Employee.Management.System.Employee.dto.EmployeeDTO;
import com.Employee.Management.System.Employee.entity.Employee;
import com.Employee.Management.System.Employee.mapper.EmployeeMapper;
import com.Employee.Management.System.Employee.repository.EmployeeRepository;
import com.Employee.Management.System.Employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeServiceImp implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private EmployeeMapper employeeMapper;

    @Override
    public  EmployeeDTO createEmployee(EmployeeDTO employeeDTO){
        Employee employee = employeeMapper.mapToEmployee(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.mapToEmployeeDto(savedEmployee);
    }
}
