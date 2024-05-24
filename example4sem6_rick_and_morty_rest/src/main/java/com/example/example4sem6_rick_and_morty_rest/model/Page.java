package com.example.example4sem6_rick_and_morty_rest.model;

import com.example.example4sem6_rick_and_morty_rest.model.incomejson.Result;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Page {
    List<Card> cards;
    public Page(List<Card> cards) {
        this.cards = cards;
    }

    public void add(List<Result> results) {
        results.forEach(result -> cards.add(new Card(result)));
    }
}
