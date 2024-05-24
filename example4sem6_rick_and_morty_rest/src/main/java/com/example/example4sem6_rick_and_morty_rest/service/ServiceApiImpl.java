package com.example.example4sem6_rick_and_morty_rest.service;

import com.example.example4sem6_rick_and_morty_rest.model.incomejson.Characters;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceApiImpl implements ServiceApi {
    private final RestTemplate template;
    private final HttpHeaders headers;
    @Value("${character.api}")
    private String characterApi;
    @Value("${character.page-substring}")
    private String characterPageSubstring;


    private Characters getCharactersAtUrl(String url) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        System.out.println(url);
        ResponseEntity<Characters> response = template.exchange(url, HttpMethod.GET, entity, Characters.class);
        return response.getBody();
    }

    @Override
    public Characters getCharactersAtPage() {
        return getCharactersAtPage(1);
    }

    @Override
    public Characters getCharactersAtPage(int page) {
        if (page < 1) {
            page = 1;
        }
        return getCharactersAtUrl(String.format("%s%s%d", characterApi, characterPageSubstring, page));
    }
}
