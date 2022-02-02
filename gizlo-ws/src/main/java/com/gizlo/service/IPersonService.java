package com.gizlo.service;

import com.gizlo.entity.Person;

public interface IPersonService {

    Person save(Person person);

    Iterable<Person> findByIdentification(String identification);

    Iterable<Person> findAll();

    Person update(Person person);

    void flushCache();
}
