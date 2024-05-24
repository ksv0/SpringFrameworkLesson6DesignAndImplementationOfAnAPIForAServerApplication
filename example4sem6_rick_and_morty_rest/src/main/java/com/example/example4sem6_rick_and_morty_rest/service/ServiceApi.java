package com.example.example4sem6_rick_and_morty_rest.service;


import com.example.example4sem6_rick_and_morty_rest.model.incomejson.Characters;


public interface ServiceApi {

    Characters getCharactersAtPage();
    Characters getCharactersAtPage(int page);
}
