package ru.gb.ksv.service;

import ru.gb.ksv.model.Note;

import java.util.List;

public interface INoteService {
    Note addNote(Note note);

    List<Note> getAllNotes();

    Note getNoteById(long id);

    Note editNote(Note note);

    void deleteNote(long id);
}
