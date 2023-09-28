package com.iftm.logpool.repositories;

import com.iftm.logpool.entities.Log;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LogRepository extends MongoRepository<Log, String> {
}
