package com.arca.test.service;

import com.arca.test.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {

    private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

    @Override
    public Person process(final Person person) throws Exception {
        final Long id = person.getId();
        final Long time = person.getTime();
        final Integer number = person.getNumber();
        final String origine = person.getOrigine();

        final Person transformedPerson = new Person(id, time, number, origine);

        log.info("Converting (" + person + ") into (" + transformedPerson + ")");

        return transformedPerson;
    }

}
