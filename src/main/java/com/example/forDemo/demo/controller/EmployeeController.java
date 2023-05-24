package com.example.forDemo.demo.controller;

import com.example.forDemo.demo.exception.ResourceNotFoundException;
import com.example.forDemo.demo.model.employee;
import com.example.forDemo.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    //get all employee
    @GetMapping("/employees")
    public List<employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    // add employee
    @PostMapping("/add_employee")
    public employee createemployee(@RequestBody employee emp){
        return employeeRepository.save(emp);
    }

    // get employee by id
    @GetMapping("/{id}")
    public ResponseEntity<employee> getEmpById(@PathVariable long id){
        employee emp = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id : "+id));
        return ResponseEntity.ok(emp);
    }

    // update employee
    @PutMapping("/{id}")
    public ResponseEntity<employee> updateEmployee(@PathVariable long id,@RequestBody employee empdetails){
        employee updateEmp = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id: "+id));
        updateEmp.setFirstName(empdetails.getFirstName());
        updateEmp.setLastName(empdetails.getLastName());
        updateEmp.setEmailId(empdetails.getEmailId());
        employeeRepository.save(updateEmp);
        return ResponseEntity.ok(updateEmp);
    }

    // delete employee
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
        employee emp = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id: "+id));
        employeeRepository.delete(emp);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
