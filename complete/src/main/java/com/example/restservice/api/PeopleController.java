package com.example.restservice.api;

import com.example.restservice.exception.PeopleNotFoundException;
import com.example.restservice.model.People;
import com.example.restservice.service.PeopleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class PeopleController {
    PeopleService peopleService = new PeopleService();

    @GetMapping("/people/{id}")
    public ResponseEntity<People> getPeopleById(@PathVariable("id") int id) {

        try{
            return new ResponseEntity<>(peopleService.getPeople(id),HttpStatus.OK);
        }
        catch (PeopleNotFoundException peopleNotFoundException){
            return new ResponseEntity(peopleNotFoundException.getMessage(),HttpStatus.NOT_FOUND);
        }
        //return new ResponseEntity<>(peopleService.getPeople(id),HttpStatus.OK);
    }

    @GetMapping("/getAllPeople")
        public ResponseEntity<ArrayList<People>> getAllPeople(){
            return new ResponseEntity(peopleService.getAllPeople(), HttpStatus.OK);
        }

    @PostMapping("/people")
    public ResponseEntity<People> postPeople(@RequestBody People people){
        if(peopleService.addPeople(people) == true){
            return new ResponseEntity<>(people, HttpStatus.OK);
        }
        return new ResponseEntity("Could not add", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/updatePerson/{name}")
    public ResponseEntity<People> updatePerson(@PathVariable String name, @RequestBody People people){
        People updated = peopleService.updatePerson(name, people);
        if (updated != null){
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
        return new ResponseEntity("Could not find person", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/deletePerson/{name}")
    public ResponseEntity deletePerson(@PathVariable String name){
        if(peopleService.deletePerson(name)){
            return new ResponseEntity("Person " + name + " deleted", HttpStatus.OK);
        }
        return new ResponseEntity("Could not delete " + name, HttpStatus.BAD_REQUEST);
    }
}
