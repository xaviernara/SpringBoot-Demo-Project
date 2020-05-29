package com.example.demo.DOA;

import com.example.demo.Model.Person;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.UUID;

@Repository("fakeDAO")
public class FakePersonDataAccessService implements PersonDOA {

    List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {

        DB.add(new Person(id, person.getName()));
        return 0;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personMaybe = selectPersonById(id);

        if(!personMaybe.isPresent()) return 0;

        DB.remove(personMaybe.get());
        return 0;
    }

    @Override
    public int updatePerson(UUID id, Person personToUpdate) {

        return selectPersonById(id).
                map(person -> {int indexOfPersonToUpdate = DB.indexOf(person);
                            if(indexOfPersonToUpdate >= 0){DB.set(indexOfPersonToUpdate,new Person(id,personToUpdate.getName()));}
                            return 1;})
                .orElse(0);
    }

}
