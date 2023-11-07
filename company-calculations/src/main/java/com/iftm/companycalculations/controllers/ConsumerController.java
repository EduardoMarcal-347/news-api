package com.iftm.companycalculations.controllers;

import com.iftm.companycalculations.entities.AnnualWage;
import com.iftm.companycalculations.services.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ConsumerController {

    @Autowired
    private ConsumerService service;

    @GetMapping("/pull")
    public ResponseEntity<AnnualWage> getAnnualWage() {
        return service.getAnnualWage();
    }

}
