package com.iftm.newsletter.repositories;

import com.iftm.newsletter.entities.Employee;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository <Employee, ObjectId> {
}
