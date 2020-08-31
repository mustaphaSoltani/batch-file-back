package com.arca.test.repository;

import com.arca.test.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query(value = "select  origine, sum(number) as total_value from person groupe group by origine", nativeQuery = true)
    List<?> sumValuesByOrigin();

    @Query(value = "select  date, sum(number) as sumValue, origine from person where date BETWEEN ?1 AND ?2 group by date", nativeQuery = true)
    List<?> sumValuesByDate(String startDate, String endDate);

    @Query(value = "select distinct origine from person", nativeQuery = true)
    List<String> findAllOrigine();

    @Query(value = "select   origine, date, sum(number) as sumValue from person where origine = ?1 AND date BETWEEN ?2 AND ?3  group by date", nativeQuery = true)
    List<?> sumValuesByDateOfOrigin(String origin, String startDate, String endDate);
}
