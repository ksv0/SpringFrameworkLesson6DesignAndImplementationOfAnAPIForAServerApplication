package ru.gb.ksv.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.ksv.model.Note;
import ru.gb.ksv.service.INoteService;

import java.util.List;

/**
 * Все методы контроллера возвращают ResponseEntity(как на семинаре)
 * 1. Добавление заметки. (Подсказка @PostMapping )
 * 2. Просмотр всех заметок.(Подсказка @GetMapping )
 * 3. Получение заметки по id. (Подсказка @GetMapping("/{id}") )
 * 4. Редактирование заметки.(Подсказка @PutMapping("/{id}") )
 * 5. Удаление заметки.(Подсказка @DeleteMapping("/{id}") )
 */
@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {
    private INoteService service;

    @PostMapping
    public ResponseEntity<Note> addNote(@RequestBody Note note) {
        return new ResponseEntity<Note>(service.addNote(note), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Note>> getNotes() {
        return new ResponseEntity<List<Note>>(service.getAllNotes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNote(@PathVariable long id) {
        return new ResponseEntity<Note>(service.getNoteById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Note> updateNote(@RequestBody Note note) {
        return new ResponseEntity<Note>(service.editNote(note), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable long id) {
        service.deleteNote(id);
        return ResponseEntity.ok().build();
    }
}
