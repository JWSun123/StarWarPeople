package com.example.restservice.adapter;

import com.example.restservice.exception.PeopleNotFoundException;
import com.example.restservice.model.People;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class PeopleAdapter {
    public ResponseEntity callPeopleApi(int id){
        String url = "https://swapi.dev/api/people/"+id;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity entity = restTemplate.getForEntity(url, People.class);
        if (entity.getStatusCode() == HttpStatus.OK){
            return entity;
        }


        throw new PeopleNotFoundException("People not found");
    }
}
