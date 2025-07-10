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
    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO){
        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
}
