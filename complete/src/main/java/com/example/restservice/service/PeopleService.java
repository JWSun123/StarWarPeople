package com.example.restservice.service;

import com.example.restservice.adapter.PeopleAdapter;
import com.example.restservice.exception.PeopleNotFoundException;
import com.example.restservice.model.People;

import java.util.ArrayList;


public class PeopleService{

    static ArrayList<People> peopleList = new ArrayList<>();

    public People getPeople(int id) {
        PeopleAdapter peopleAdapter = new PeopleAdapter();
        if(id < 0){
            throw new PeopleNotFoundException("Invalid id");
        }
        People people = peopleAdapter.callPeopleApi(id);

        peopleList.add(people);
        return people;
    }

    public boolean addPeople(People people){
        peopleList.add(people);
        return true;
    }
    public ArrayList<People> getAllPeople(){
        return peopleList;
    }

    public People updatePerson(String name, People update){
        for (People people: peopleList){
            if (people.getName().equals(name)){
                people.setHeight(update.getHeight());
                people.setFilms(update.getFilms());
                people.setHairColor(update.getHairColor());
                return people;
            }
        }
        return null;
    }

    public boolean deletePerson(String name){
        for (People people: peopleList){
            if (people.getName().equals(name)){
                peopleList.remove(people);
                return true;
            }
        }
        return false;
    }
}