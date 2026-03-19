package com.javawithabhi.ems.backend.service;

import com.javawithabhi.ems.backend.dto.EmployeeDto;


public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);
}
