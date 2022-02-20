package com.example.restservice.service;

import com.example.restservice.adapter.PeopleAdapter;
import com.example.restservice.exception.PeopleNotFoundException;
import com.example.restservice.model.People;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;


public class PeopleService{
    PeopleAdapter peopleAdapter = new PeopleAdapter();
    public ResponseEntity getPeople(int id) {
        return peopleAdapter.callPeopleApi(id);
    }
}