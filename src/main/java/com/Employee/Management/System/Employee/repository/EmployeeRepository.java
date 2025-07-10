package com.Employee.Management.System.Employee.repository;

import com.Employee.Management.System.Employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee , Long> {

}
