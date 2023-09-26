package com.iftm.newsletter.repositories;

import com.iftm.newsletter.entities.News;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends MongoRepository<News, ObjectId> {
}
