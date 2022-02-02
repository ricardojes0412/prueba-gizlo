package com.gizlo.service;

import com.gizlo.entity.Person;
import com.gizlo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class PersonImpl implements IPersonService {

    @Autowired
    private PersonRepository _repository;

    @Override
    public Person save(Person person) {
        return _repository.save(person);
    }

    @Override
    public Iterable<Person> findByIdentification(String identification) {
        return _repository.findPersonByIdentification(identification);
    }

    @Override
    @Cacheable(cacheNames = "persons")
    public Iterable<Person> findAll() {
        return _repository.findAll();
    }

    @Override
    @CachePut(cacheNames = "persons", key = "#person.id")
    public Person update(Person person) {
        return _repository.save(person);
    }

    @CacheEvict(cacheNames = "persons", allEntries = true)
    public void flushCache() {
    }
}
