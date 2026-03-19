package com.javawithabhi.ems.backend.controller;

import com.javawithabhi.ems.backend.dto.EmployeeDto;
import com.javawithabhi.ems.backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

//    Add Employee rest End point
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto employeeResponse = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(employeeResponse, HttpStatus.CREATED);
    }

//    Fetch employee data By employeeId
    @GetMapping("{employeeId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long employeeId){
        EmployeeDto employeeDto =  employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }
//    get All Employees
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
        List<EmployeeDto> employeeDtoList = employeeService.getAllEmployee();
        return new ResponseEntity<>(employeeDtoList, HttpStatus.OK);
    }

//    Build employee update Rest API Rest Controller
    @PutMapping("{employeeId}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable  Long employeeId, @RequestBody EmployeeDto updateEmployee){
      EmployeeDto employeeDto =  employeeService.updateEmployee(employeeId, updateEmployee);
      return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }
//  Delete Employee by its ID
    @DeleteMapping("{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully with id : " + employeeId);
    }
}
