package com.javawithabhi.ems.backend.service.impl;

import com.javawithabhi.ems.backend.dto.EmployeeDto;
import com.javawithabhi.ems.backend.entity.Employee;
import com.javawithabhi.ems.backend.exception.ResourceNotFoundException;
import com.javawithabhi.ems.backend.mapper.EmployeeMapper;
import com.javawithabhi.ems.backend.repository.EmployeeRepository;
import com.javawithabhi.ems.backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {

      Employee employee = employeeRepository.
              findById(employeeId).
              orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with given id : " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee savedEmployee = employeeRepository.
                findById(employeeId).
                orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with given id : " + employeeId));
        savedEmployee.setFirstName(updatedEmployee.getFirstName() !=null ? updatedEmployee.getFirstName() : savedEmployee.getFirstName());
        savedEmployee.setLastName(updatedEmployee.getLastName()!=null ? updatedEmployee.getLastName() : savedEmployee.getLastName());
        savedEmployee.setEmail( updatedEmployee.getEmail());
        Employee updatedEmployeeObj   = employeeRepository.save(savedEmployee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.
                findById(employeeId).
                orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with given id : " + employeeId));
        employeeRepository.deleteById(employeeId);
    }

}
