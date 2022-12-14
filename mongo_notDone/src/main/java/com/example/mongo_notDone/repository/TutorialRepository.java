package com.example.mongo_notDone.repository;


import com.example.mongo_notDone.model.Tutorial;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TutorialRepository extends MongoRepository<Tutorial, String> {
    List<Tutorial> findByTitleContaining (String title);
    List<Tutorial> findByPublished (boolean published);
}
