package com.javawithabhi.ems.backend.service.impl;

import com.javawithabhi.ems.backend.dto.EmployeeDto;
import com.javawithabhi.ems.backend.entity.Employee;
import com.javawithabhi.ems.backend.mapper.EmployeeMapper;
import com.javawithabhi.ems.backend.repository.EmployeeRepository;
import com.javawithabhi.ems.backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository  employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployeeEntity(employeeDto);
       Employee savedEmployee= employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

}
