package com.Employee.Management.System.Employee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}