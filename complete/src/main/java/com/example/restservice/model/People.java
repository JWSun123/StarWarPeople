package com.example.restservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class People {
    private String name;
    private String height;
    @JsonProperty("hair_color")
    private String hairColor;
    private List<String> films;
}
