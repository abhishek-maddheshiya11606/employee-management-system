package com.javawithabhi.ems.backend.controller;

import com.javawithabhi.ems.backend.dto.EmployeeDto;
import com.javawithabhi.ems.backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

//    Add Employee rest End point
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto employeeResponse = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
    }

//    Fetch employee


}
