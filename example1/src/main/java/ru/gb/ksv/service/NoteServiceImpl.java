package ru.gb.ksv.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.ksv.model.Note;
import ru.gb.ksv.repository.NoteRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements INoteService {
    NoteRepo repository;

    @Override
    public Note addNote(Note note) {
        return repository.save(note);
    }

    @Override
    public List<Note> getAllNotes() {
        return repository.findAll();
    }

    @Override
    public Note getNoteById(long id) {
        return repository.findById(id).orElseThrow(null);
    }

    @Override
    public Note editNote(Note note) {
        Note recievedNote = repository.findById(note.getId()).orElseThrow(null);
        recievedNote.setHeader(note.getHeader());
        recievedNote.setContent(note.getContent());
        return repository.save(recievedNote);
    }

    @Override
    public void deleteNote(long id) {
        repository.deleteById(id);
    }
}
