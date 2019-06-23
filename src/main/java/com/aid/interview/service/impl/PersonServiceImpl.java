package com.aid.interview.service.impl;

import com.aid.interview.model.Person;
import com.aid.interview.repository.PersonRepository;
import com.aid.interview.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Page<Person> findAll(Pageable pageable) {
        return personRepository.findAll(pageable);
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person deletePerson(String id) {
        Person personToDelete = personRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);

        personRepository.delete(personToDelete);
        return personToDelete;
    }
}
