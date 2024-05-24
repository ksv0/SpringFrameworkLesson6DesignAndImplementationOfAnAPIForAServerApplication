package com.example.example4sem6_rick_and_morty_rest.service.pageservice;

import com.example.example4sem6_rick_and_morty_rest.model.Page;
@Deprecated
public interface IPageService {
    void reloadCharacters();

    int check(int page);

    Page getPageAt(int pageNumber);
}
