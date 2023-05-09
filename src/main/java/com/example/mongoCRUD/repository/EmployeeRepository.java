package com.example.mongoCRUD.repository;

import com.example.mongoCRUD.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Rajyalaxmi_Thumarada on 06-03-2023
 */
public interface EmployeeRepository extends MongoRepository<Employee,Integer> {
}
