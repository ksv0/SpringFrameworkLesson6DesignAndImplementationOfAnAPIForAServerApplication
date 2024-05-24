package com.example.example4sem6_rick_and_morty_rest.service.charactermanagementservice;

import com.example.example4sem6_rick_and_morty_rest.model.Page;

public interface IManagementService {
    void loadCharacters();

    boolean isChanged();

    boolean isEmpty();

    int count();

    Page getPageAt(int pageNumber);

    void reloadCharacters();

    int check(int pageNumber);
}
