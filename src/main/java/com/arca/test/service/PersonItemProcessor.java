package com.arca.test.service;

import com.arca.test.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {

    private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

    @Override
    public Person process(final Person person) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        final Long id = person.getId();
        final Long time = person.getTime();
        final Integer number = person.getNumber();
        final String origine = person.getOrigine();
        final String date = sdf.format(new Date(person.getTime()));

        final Person transformedPerson = new Person(id, time, number, origine, date);

        log.info("Converting (" + person + ") into (" + transformedPerson + ")");

        return transformedPerson;
    }

}
