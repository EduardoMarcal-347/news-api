package com.iftm.newsletter.services;

import com.iftm.newsletter.entities.dtos.EmployeeDto;
import com.iftm.newsletter.entities.dtos.LogDto;
import com.iftm.newsletter.entities.dtos.NewsDto;
import com.iftm.newsletter.repositories.EmployeeRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public ResponseEntity<List<EmployeeDto>> findAll() {
        var dbEmployees = repository.findAll();
        if (dbEmployees.isEmpty()) return ResponseEntity.notFound().build();
        var dbEmployeesDto = dbEmployees.stream().map(employee -> {
            return new EmployeeDto(employee);
        }).collect(Collectors.toList());
        return ResponseEntity.ok(dbEmployeesDto);
    }

    public ResponseEntity<EmployeeDto> findById(ObjectId id) {
        if (id == null) return ResponseEntity.badRequest().build();

        var employee = repository.findById(id);
        if (employee.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new EmployeeDto(employee.get()));
    }

    public ResponseEntity<EmployeeDto> save(EmployeeDto employee) {
        if (employee.getFirstName().isBlank() || employee.getLastName().isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        var dbEmployee = new EmployeeDto(repository.save(employee.toEmployee()));

        return ResponseEntity.ok(dbEmployee);
    }

}
