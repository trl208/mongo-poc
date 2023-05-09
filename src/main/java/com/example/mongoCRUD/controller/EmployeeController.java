package com.example.mongoCRUD.controller;

import com.example.mongoCRUD.model.Employee;
import com.example.mongoCRUD.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rajyalaxmi_Thumarada on 06-03-2023
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/")
    public ResponseEntity<Employee> create(@RequestBody Employee emp) {
        return new ResponseEntity<Employee>(employeeService.create(emp), HttpStatus.ACCEPTED);
    }

    @PutMapping("/")
    public ResponseEntity<Employee> update(@RequestBody Employee emp) {
        return new ResponseEntity<Employee>(employeeService.update(emp), HttpStatus.ACCEPTED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Employee>> findAll() {
        return new ResponseEntity<List<Employee>>(employeeService.findAll(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Integer id) {
        return new ResponseEntity<Employee>(employeeService.findById(id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/")
    public ResponseEntity<String> delete(@RequestBody Employee emp) {
         employeeService.delete(emp);
        return new ResponseEntity<>("Employee deleted" , HttpStatus.ACCEPTED);
    }
}
