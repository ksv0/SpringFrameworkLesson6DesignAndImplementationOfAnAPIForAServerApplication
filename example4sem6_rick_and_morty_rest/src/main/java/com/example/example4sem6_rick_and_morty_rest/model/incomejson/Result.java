package com.example.example4sem6_rick_and_morty_rest.model.incomejson;

import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
public class Result {
    @Id
    private Integer id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private String image;
    private String url;
    private Date created;
}
