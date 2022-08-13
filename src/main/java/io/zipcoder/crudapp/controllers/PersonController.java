package io.zipcoder.crudapp.controllers;

import io.zipcoder.crudapp.models.Person;
import io.zipcoder.crudapp.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    private PersonService personService;

    public PersonController (PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/people")
    public ResponseEntity<Person> createPerson(@RequestBody Person p) {
        return new ResponseEntity<>(personService.createPerson(p), HttpStatus.CREATED);
    }
    @GetMapping("/people/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable int id) {
        return new ResponseEntity<>(personService.getPerson(id), HttpStatus.OK);
    }
    @GetMapping("/people")
    public ResponseEntity<List<Person>> getPersonList() {
        return new ResponseEntity<>(personService.getPersonList(), HttpStatus.OK);
    }
    @PutMapping("/people/{id}")
    public ResponseEntity<Person> updatePerson(@RequestBody Person p, @PathVariable int id) {
        return new ResponseEntity<>(personService.updatePerson(p), HttpStatus.OK);
    }
    @DeleteMapping("/people/{id}")
    public ResponseEntity<Boolean> DeletePerson(@PathVariable int id) {
        return new ResponseEntity<>(personService.deletePerson(id), HttpStatus.NO_CONTENT);
    }
}
