package com.example.demo.DOA;

import com.example.demo.Model.Person;

import java.util.UUID;

public interface PersonDOA {

    //Used to insert a Person with a id
    public int insertPerson(UUID id, Person person);

    //Used to add a person even if they dont have a id
    //creates random id for the person
    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }





}
