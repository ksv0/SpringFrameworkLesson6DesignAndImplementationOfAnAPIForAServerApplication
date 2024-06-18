package ru.gb.ksv.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String header;
    private String content;
    private LocalDateTime createdAt;
    public Note() {
        this.createdAt = LocalDateTime.now();
    }
}
