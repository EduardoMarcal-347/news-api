package com.iftm.companycalculations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CompanyCalculationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyCalculationsApplication.class, args);
	}

}
