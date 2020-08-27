package com.arca.test.repository;

import com.arca.test.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query(value = "select  origine, sum(number) as total_value from person groupe group by origine", nativeQuery = true)
    List<?> findPerson();
}
