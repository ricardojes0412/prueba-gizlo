package com.gizlo.repository;

import com.gizlo.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface PersonRepository extends MongoRepository<Person, String> {

    Iterable<Person> findPersonByIdentification(String identification);
}
