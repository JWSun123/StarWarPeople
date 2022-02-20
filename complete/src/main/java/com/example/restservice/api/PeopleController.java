package com.example.restservice.api;

import com.example.restservice.exception.PeopleNotFoundException;
import com.example.restservice.model.People;
import com.example.restservice.service.PeopleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PeopleController {
    PeopleService peopleService = new PeopleService();

    @GetMapping("/people/{id}")
    public ResponseEntity getPeopleById(@PathVariable int id) {
        return peopleService.getPeople(id);
    }
}
