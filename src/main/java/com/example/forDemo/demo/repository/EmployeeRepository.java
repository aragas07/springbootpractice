package com.example.forDemo.demo.repository;

import com.example.forDemo.demo.model.employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<employee, Long> {
}
