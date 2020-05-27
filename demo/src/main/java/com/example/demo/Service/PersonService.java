package com.example.demo.Service;

import com.example.demo.DOA.PersonDOA;
import com.example.demo.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PersonService {


    private final PersonDOA personDOA;

    @Autowired
    public PersonService(@Qualifier("fakeDOA") PersonDOA personDOA) {
        this.personDOA = personDOA;
    }

    public int addPerson(Person person){

        return personDOA.insertPerson(person);
    }


    public List<Person> getAllPeople(){
        return personDOA.selectAllPeople();
    }

    public Optional<Person> selectPersonById(UUID id) {
        return personDOA.selectPersonById(id);
    }



}
