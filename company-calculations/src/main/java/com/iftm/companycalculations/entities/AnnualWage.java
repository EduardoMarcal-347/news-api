package com.iftm.companycalculations.entities;

import com.iftm.companycalculations.entities.dto.EmployeeDto;

public class AnnualWage {

    private String firstName;
    private Double annualWage;

    public AnnualWage(EmployeeDto entity) {
        this.firstName = entity.getFirstName();
        this.annualWage = entity.getWage() * 12;
    }

    public Double getAnnualWage() {
        return annualWage;
    }

    public void setAnnualWage(Double annualWage) {
        this.annualWage = annualWage;
    }
}
