package com.example.example4sem6_rick_and_morty_rest.model.incomejson;

import lombok.Data;

import java.util.List;

@Data
public class Characters {
    Info info;
    List<Result> results;
}
