package com.aid.interview.service;

import com.aid.interview.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonService {

    Page<Person> findAll(Pageable pageable);

    Person savePerson(Person person);

    Person deletePerson(String id);
}
