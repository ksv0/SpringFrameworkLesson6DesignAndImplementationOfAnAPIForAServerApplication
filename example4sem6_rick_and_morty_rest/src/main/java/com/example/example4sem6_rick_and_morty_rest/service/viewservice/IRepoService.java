package com.example.example4sem6_rick_and_morty_rest.service.viewservice;

import org.springframework.stereotype.Service;

@Deprecated
public interface IRepoService {
    void reloadCharacters();

    void loadCharacters();

    boolean isChanged();

    boolean isEmpty();

    int count();
}
