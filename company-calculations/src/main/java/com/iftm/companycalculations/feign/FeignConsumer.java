package com.iftm.companycalculations.feign;

import com.iftm.companycalculations.entities.dto.EmployeeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "producer")
public interface FeignConsumer {
    @GetMapping("api/v1/employee")
    ResponseEntity<EmployeeDto> getEmployee();
}
