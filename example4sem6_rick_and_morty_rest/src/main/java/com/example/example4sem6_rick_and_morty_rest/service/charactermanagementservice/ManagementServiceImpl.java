package com.example.example4sem6_rick_and_morty_rest.service.charactermanagementservice;

import com.example.example4sem6_rick_and_morty_rest.model.Card;
import com.example.example4sem6_rick_and_morty_rest.model.Page;
import com.example.example4sem6_rick_and_morty_rest.model.incomejson.Result;
import com.example.example4sem6_rick_and_morty_rest.model.incomejson.Characters;
import com.example.example4sem6_rick_and_morty_rest.repo.ICharacterRepo;
import com.example.example4sem6_rick_and_morty_rest.service.ServiceApi;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManagementServiceImpl implements IManagementService {

    private final ICharacterRepo repo;

    private final ServiceApi api;

    @Value("${character.page-substring}")
    private String pageSubstring;

    @Value("${character.page-size}")
    private int pageSize ;
    private int pagesCount ;

    @Override
    public void reloadCharacters() {
        repo.deleteAll();
        loadCharacters();
    }

    @Override
    public int check(int page) {
        if (repo.count() == 0) {
            return 0;
        }
        if (checkOutOfBounds(page)) {
            if (page < 1) {
                page = 1;
            } else {
                page = pagesCount;
            }
        }
        return page;
    }

    @Override
    public void loadCharacters() {
        Characters characters = api.getCharactersAtPage();
        String url = characters.getInfo().getNext();

        while (characters.getInfo().getNext()!= null) {
            for (Result result : characters.getResults()) {
                repo.save(new Card(result));
            }
            characters = api.getCharactersAtPage(Integer.parseInt(url.substring(url.indexOf(pageSubstring) + pageSubstring.length())));
            url = characters.getInfo().getNext();
        }
        pagesCount = (int) Math.round((double) repo.count() / pageSize);
    }

    @Override
    public boolean isChanged() {
        return api.getCharactersAtPage().getInfo().getCount()!= repo.count();
    }

    @Override
    public boolean isEmpty() {
        return repo.count() == 0;
    }

    @Override
    public int count() {
        return (int) repo.count();
    }

    @Override
    public Page getPageAt(int pageNumber) {
        if (isEmpty()) {
            return null;
        }
        if (checkOutOfBounds(pageNumber)) {
            if (pageNumber < 1) {
                pageNumber = 1;
            } else {
                pageNumber = pagesCount;
            }
        }
        return new Page(getCharacters((pageNumber - 1) * pageSize, pageSize));
    }

    private List<Card> getCharacters(int offset, int limit) {
         return repo.findAll(PageRequest.of(offset, limit)).getContent();
    }

    private boolean checkOutOfBounds(int page) {
        return page < 1 || page > pagesCount;
    }
}