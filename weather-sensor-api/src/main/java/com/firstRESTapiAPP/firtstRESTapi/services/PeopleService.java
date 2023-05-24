//package com.firstRESTapiAPP.firtstRESTapi.services;
//
//import com.firstRESTapiAPP.firtstRESTapi.models.Person;
//import com.firstRESTapiAPP.firtstRESTapi.repositories.PeopleRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@Transactional(readOnly = true)
//public class PeopleService {
//
//    private  final PeopleRepository peopleRepository;
//
//    @Autowired
//    public PeopleService(PeopleRepository peopleRepository) {
//        this.peopleRepository = peopleRepository;
//    }
//
//
//    @Transactional
//    public void save(Person person){
//        enrichPerson(person);
//        peopleRepository.save(person);
//    }
//
//
//    private void enrichPerson(Person person) {
//        person.setCreated_at(LocalDateTime.now());
//        person.setUpdated_at(LocalDateTime.now());
//        person.setCreated_who("ADMIN");
//    }
//
//}
