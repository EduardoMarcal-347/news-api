package com.iftm.newsletter.controllers;


import com.iftm.newsletter.entities.dtos.EmployeeDto;
import com.iftm.newsletter.entities.dtos.NewsDto;
import com.iftm.newsletter.services.EmployeeService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @Value("${eureka.instance.instance-id}")
    private String instanceId;

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> findAll(){
        return service.findAll();
    }

    @GetMapping("id/{id}")
    public ResponseEntity<EmployeeDto> findById(@PathVariable("id") ObjectId id){
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> create(@RequestBody EmployeeDto employee) {
        return service.save(employee);
    }



}
