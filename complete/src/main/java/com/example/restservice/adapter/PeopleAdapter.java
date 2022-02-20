package com.example.restservice.adapter;

import com.example.restservice.exception.PeopleNotFoundException;
import com.example.restservice.model.People;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class PeopleAdapter {
    public People callPeopleApi(int id){
        String url = "https://swapi.py4e.com/api/people/" + id;
        try {
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForObject(url, People.class);
        }
        catch(RestClientException e){
            throw new PeopleNotFoundException("People not found");
        }
    }
}
