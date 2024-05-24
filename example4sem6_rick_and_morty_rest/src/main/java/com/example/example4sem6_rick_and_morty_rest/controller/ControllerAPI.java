package com.example.example4sem6_rick_and_morty_rest.controller;

import com.example.example4sem6_rick_and_morty_rest.model.incomejson.Characters;
import com.example.example4sem6_rick_and_morty_rest.service.ServiceApi;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ControllerAPI {

    private ServiceApi serviceApi;

    @GetMapping("/api/")
    public ResponseEntity<Characters> getCharacters() {
        Characters characters = serviceApi.getCharactersAtPage();

        return new ResponseEntity<>(characters, HttpStatus.OK);
    }

    @GetMapping("/api/{page}")
    public ResponseEntity<Characters> getCharacters(@PathVariable int page) {
        Characters characters = serviceApi.getCharactersAtPage(page);
        return new ResponseEntity<>(characters, HttpStatus.OK);
    }
}
