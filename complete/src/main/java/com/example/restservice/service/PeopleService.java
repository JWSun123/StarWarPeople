package com.example.restservice.service;

import com.example.restservice.adapter.PeopleAdapter;
import com.example.restservice.exception.PeopleNotFoundException;
import com.example.restservice.model.People;


public class PeopleService{
    public People getPeople(int id) {
        PeopleAdapter peopleAdapter = new PeopleAdapter();
        if(id < 0){
            throw new PeopleNotFoundException("Invalid id");
        }
        return peopleAdapter.callPeopleApi(id);
    }
}