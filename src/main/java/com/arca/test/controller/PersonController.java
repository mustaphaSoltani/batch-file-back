package com.arca.test.controller;

import com.arca.test.domain.Person;
import com.arca.test.repository.PersonRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @RequestMapping("/api/person")
    public List<Person> findAllPersonByOrigin() throws Exception {
        return this.personRepository.findPerson();

    }
}
