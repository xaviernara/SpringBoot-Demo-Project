package com.example.demo.DOA;

import com.example.demo.Model.Person;

import java.util.*;
import java.util.UUID;

public class FakePersonDataAccessService implements PersonDOA {

    List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {

        DB.add(new Person(id, person.getName()));
        return 0;
    }
}
