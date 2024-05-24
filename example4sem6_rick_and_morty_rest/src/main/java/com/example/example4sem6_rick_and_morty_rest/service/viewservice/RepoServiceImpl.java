package com.example.example4sem6_rick_and_morty_rest.service.viewservice;

import com.example.example4sem6_rick_and_morty_rest.model.Card;
import com.example.example4sem6_rick_and_morty_rest.model.incomejson.Result;
import com.example.example4sem6_rick_and_morty_rest.service.ServiceApi;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.example.example4sem6_rick_and_morty_rest.model.incomejson.Characters;
import com.example.example4sem6_rick_and_morty_rest.repo.ICharacterRepo;

@Deprecated
@Service
@RequiredArgsConstructor
public class RepoServiceImpl implements IRepoService {

    private final ICharacterRepo repo;

    private final ServiceApi api;

    @Value("${character.page-substring}")
    private String pageSubstring;

    @Override
    public void reloadCharacters() {
        repo.deleteAll();
        loadCharacters();
    }

    @Override
    public void loadCharacters() {
        Characters characters = api.getCharactersAtPage();
        String url = characters.getInfo().getNext();

        while (characters.getInfo().getNext() != null) {
            for (Result result : characters.getResults()) {
                repo.save(new Card(result));
            }
            characters = api.getCharactersAtPage(Integer.parseInt(url.substring(url.indexOf(pageSubstring) + pageSubstring.length())));
            url = characters.getInfo().getNext();
        }
    }

    @Override
    public boolean isChanged() {
        return api.getCharactersAtPage().getInfo().getCount() != repo.count();
    }

    @Override
    public boolean isEmpty() {
        return repo.count() == 0;
    }

    @Override
    public int count() {
        return (int) repo.count();
    }
}
