package com.firstRESTapiAPP.firtstRESTapi.repositories;

import com.firstRESTapiAPP.firtstRESTapi.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleRepository  extends JpaRepository<Person,Integer> {
    List<Person>  findByName(String name);

    List<Person> findByEmailOrderByName(String email);

    void countAllByAgeAfter(int age);

}
