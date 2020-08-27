package com.arca.test.controller;

import com.arca.test.domain.Person;
import com.arca.test.repository.PersonRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/data")
    public List<?> findAllPersonByOrigin() {
        return this.personRepository.findPerson();
    }

    @GetMapping("/person")
    public List<Person> findAllPerson() {
        return this.personRepository.findAll();
    }
}
