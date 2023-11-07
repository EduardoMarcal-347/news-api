package com.iftm.companycalculations.feign;

import com.iftm.companycalculations.entities.dto.EmployeeDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "producer")
public interface FeignConsumer {
    @GetMapping("api/v1/employee")
    @CircuitBreaker(name = "consumer", fallbackMethod = "getResponse")
    ResponseEntity<EmployeeDto> getEmployee();

    default ResponseEntity<String> getEmployee(Throwable t) {
        var message = "Erro ao tentar acessar o microsserviço producer!";
        return ResponseEntity.internalServerError().body("Fallback response!");
    }
}
