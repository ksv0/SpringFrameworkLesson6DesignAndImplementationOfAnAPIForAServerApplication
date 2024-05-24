package com.example.example4sem6_rick_and_morty_rest.model.incomejson;

import lombok.Data;

@Data
public class Info {
    private Integer count;
    private Integer pages;
    private String next;
    private String prev;
}
