package com.example.demo.Service;

import com.example.demo.DOA.PersonDOA;
import com.example.demo.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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



}
