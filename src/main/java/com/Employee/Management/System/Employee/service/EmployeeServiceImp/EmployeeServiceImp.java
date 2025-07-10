package com.Employee.Management.System.Employee.service.EmployeeServiceImp;

import com.Employee.Management.System.Employee.dto.EmployeeDTO;
import com.Employee.Management.System.Employee.entity.Employee;
import com.Employee.Management.System.Employee.exception.ResourceNotFoudException;
import com.Employee.Management.System.Employee.mapper.EmployeeMapper;
import com.Employee.Management.System.Employee.repository.EmployeeRepository;
import com.Employee.Management.System.Employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Service
@AllArgsConstructor

public class EmployeeServiceImp implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private EmployeeMapper employeeMapper;

    @Override
    public  EmployeeDTO createEmployee(EmployeeDTO employeeDTO){
        Employee employee = employeeMapper.mapToEmployee(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id){
    Employee employee = employeeRepository.findById(id)
            .orElseThrow(()->new ResourceNotFoudException("Employee is not exists by given ID "+ id));
    return employeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDTO> getEmployees(){
        List<Employee> employee = employeeRepository.findAll();
        return employee.stream().map(employeeMapper::mapToEmployeeDto).toList();
    }

    @Override
    public EmployeeDTO updateEmployee(Long id,EmployeeDTO updatedEmployee){
        Employee employee = employeeRepository.findById(id).
                orElseThrow(()->new ResourceNotFoudException("Employee is not exists by given ID "+ id));
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        return employeeMapper.mapToEmployeeDto(employee);
    }

    public String deleteEmployee(Long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoudException("Employee is not exists by give id : "+id));
        employeeRepository.delete(employee);
        return "Employee is deleted from id : "+id;
    }
}
