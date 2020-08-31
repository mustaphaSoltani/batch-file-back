package com.arca.test.controller;

import com.arca.test.repository.PersonRepository;
import org.springframework.web.bind.annotation.*;

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
    public List<?> sumValuesByOrigin() {
        return this.personRepository.sumValuesByOrigin();
    }

    @GetMapping("/sumValue")
    public List<?> sumValuesByDate(@RequestParam String year, @RequestParam String startDate, @RequestParam String endDate) {
        if (!"0".equals(year)) {
            startDate = year + "-01-01";
            endDate = year + "-12-31";
        }
        return this.personRepository.sumValuesByDate(startDate, endDate);
    }

    @GetMapping("/origin")
    public List<String> getAllOrigin() {
        return this.personRepository.findAllOrigine();
    }

    @GetMapping("/dataByOrigin")
    public List<?> getAllOrigin(@RequestParam String year, @RequestParam String startDate,
                                @RequestParam String endDate, @RequestParam String origin) {
        if (!"0".equals(year)) {
            startDate = year + "-01-01";
            endDate = year + "-12-31";
        }
        return this.personRepository.sumValuesByDateOfOrigin(origin, startDate, endDate);
    }
}
