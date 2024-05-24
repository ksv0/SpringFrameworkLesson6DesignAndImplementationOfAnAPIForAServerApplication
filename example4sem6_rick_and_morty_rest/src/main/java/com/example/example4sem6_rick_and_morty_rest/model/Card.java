package com.example.example4sem6_rick_and_morty_rest.model;

import com.example.example4sem6_rick_and_morty_rest.model.incomejson.Result;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "character")
public class Card {
    @Id
    private Integer id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    @Lob
    @Column(name = "image", columnDefinition = "bytea")
    private byte[] image;
    private Date created;

    public Card(Result result) {
        this.id = result.getId();
        this.name = result.getName();
        this.status = result.getStatus();
        this.species = result.getSpecies();
        this.type = result.getType();
        this.gender = result.getGender();
        this.image = result.getImage().getBytes();
        this.created = result.getCreated();
    }
}
