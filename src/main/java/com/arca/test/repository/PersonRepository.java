package com.arca.test.repository;

import com.arca.test.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query(value="select distinct origine, sum(number) as total_value from person group by origine", nativeQuery = true)
    List<Person> findPerson();
}
