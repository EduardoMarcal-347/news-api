package com.iftm.companycalculations.services;

import com.iftm.companycalculations.entities.AnnualWage;
import com.iftm.companycalculations.feign.FeignConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class ConsumerService {

    @Autowired
    FeignConsumer feignConsumer;

    public ResponseEntity<AnnualWage> getAnnualWage() {
        var employee  = feignConsumer.getEmployee();
        if(employee.getBody() == null)
            ResponseEntity.internalServerError();

        var annualWage = new AnnualWage(employee.getBody());
        return ResponseEntity.ok().body(annualWage);
    }
}
