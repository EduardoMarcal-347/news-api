package com.iftm.newsletter.entities.dtos;

import com.iftm.newsletter.entities.Employee;
import com.iftm.newsletter.entities.News;
import org.bson.types.ObjectId;

import java.util.Objects;

public class EmployeeDto {

    private String id;
    private String firstName;
    private String lastName;
    private String level;
    private Double wage;

    public EmployeeDto() {
    }

    public EmployeeDto(String id, String firstName, String lastName, String level, Double wage) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.level = level;
        this.wage = wage;
    }

    public EmployeeDto(Employee entity) {
        this.id = entity.getId().toString();
        this.firstName = entity.getFirstName();
        this.lastName = entity.getLastName();
        this.level = entity.getLevel();
        this.wage = entity.getWage();
    }

    public Employee toEmployee(){
        ObjectId id = null;
        if(this.id != null) id = new ObjectId(this.id);
        return new Employee(
                id,
                this.firstName,
                this.lastName,
                this.level,
                this.wage
        );
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Double getWage() {
        return wage;
    }

    public void setWage(Double wage) {
        this.wage = wage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDto that = (EmployeeDto) o;
        return Objects.equals(id, that.id) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }
}
