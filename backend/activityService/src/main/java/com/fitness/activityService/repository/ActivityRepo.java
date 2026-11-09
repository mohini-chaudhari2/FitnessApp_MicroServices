package com.fitness.activityService.repository;

import com.fitness.activityService.model.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepo extends MongoRepository<Activity,String> {

}
