package com.aid.interview.web.controller;

import com.aid.interview.model.Person;
import com.aid.interview.service.PersonService;
import com.aid.interview.web.util.PaginationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final Logger log = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseEntity<List<Person>> getPersons(Pageable pageable) {
        log.info("Request to get the page of persons " + pageable);
        Page<Person> page = personService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHeaders(page);
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> savePerson(@Valid @RequestBody Person person) {
        log.info("Request to save person " + person);
        Person savedPerson = personService.savePerson(person);
        return ResponseEntity.ok(savedPerson);
    }

    @DeleteMapping("/{personId}")
    public ResponseEntity<Person> deletePerson(@PathVariable String personId) {
        log.info("Request to delete person with id " + personId);
        Person deletedPerson = personService.deletePerson(personId);
        return ResponseEntity.ok(deletedPerson);
    }
}
