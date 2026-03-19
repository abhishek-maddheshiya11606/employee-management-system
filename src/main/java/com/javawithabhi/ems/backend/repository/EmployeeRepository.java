package com.javawithabhi.ems.backend.repository;

import com.javawithabhi.ems.backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
