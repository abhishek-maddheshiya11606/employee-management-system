package com.javawithabhi.ems.backend.mapper;

import com.javawithabhi.ems.backend.dto.EmployeeDto;
import com.javawithabhi.ems.backend.entity.Employee;



public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return  new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmployeeEntity(EmployeeDto employeeDto){
        return  new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
