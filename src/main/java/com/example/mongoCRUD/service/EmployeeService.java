package com.example.mongoCRUD.service;

import com.example.mongoCRUD.exceptions.EmployeeAlreadyExistsException;
import com.example.mongoCRUD.exceptions.NoSuchEmployeeExistsException;
import com.example.mongoCRUD.model.Employee;
import com.example.mongoCRUD.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Rajyalaxmi_Thumarada on 06-03-2023
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee update(Employee emp) {
        Employee existingEmp = employeeRepository.findById(emp.getId()).orElse(null);
        if(existingEmp == null) {
            throw new NoSuchEmployeeExistsException("No Employee present with ID ::: " + emp.getId());
        } else {
            return employeeRepository.save(emp);
        }
    }

    public Employee create(Employee emp) {
        Employee existingEmp = employeeRepository.findById(emp.getId()).orElse(null);
        if(existingEmp == null) {
            return employeeRepository.save(emp);
        } else {
         throw new EmployeeAlreadyExistsException("Employee with this id already exists ::: " + emp.getId());
        }

    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public void delete(Employee emp) {
        Employee existingEmp = employeeRepository.findById(emp.getId()).orElse(null);
        if(existingEmp != null) {
            employeeRepository.delete(emp);
        } else {
            throw new NoSuchEmployeeExistsException("No Employee present with ID ::: " + emp.getId());
        }
    }

    public Employee findById(Integer id) {
        return  employeeRepository.findById(id).orElseThrow(
                () -> new NoSuchEmployeeExistsException( "No Employee present with ID ::: " + id ));

    }
}
