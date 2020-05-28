package com.example.demo.API;
import com.example.demo.Model.Person;
import com.example.demo.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//creating path for POSTMAN to send post requests
@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    /*
        https://www.restapitutorial.com/lessons/httpmethods.html
        HTTP Verbs/CRUD:

        Post - Create (The POST verb is most-often utilized to **create** new resources. In particular, it's used to create subordinate resources.)
        Get - Read (The HTTP GET method is used to **read** (or retrieve) a representation of a resource. In the “happy” (or non-error) path, GET returns a representation in XML or JSON and an HTTP response code of 200 (OK). In an error case, it most often returns a 404 (NOT FOUND) or 400 (BAD REQUEST).)
        Put - Update/Replace (PUT is most-often utilized for **update** capabilities, PUT-ing to a known resource URI with the request body containing the newly-updated representation of the original resource.)
        Patch - Update/Modify (PATCH is used for **modify** capabilities. The PATCH request only needs to contain the changes to the resource, not the complete resource.)
        Delete - Delete ( It is used to **delete** a resource identified by a URI.)
     */

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person){

        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id) {
        return personService.selectPersonById(id).orElse(null);
    }

}
