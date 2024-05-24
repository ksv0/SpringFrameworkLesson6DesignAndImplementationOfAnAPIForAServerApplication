package ru.gb.ksv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.ksv.model.Note;

import java.util.Optional;

public interface NoteRepo extends JpaRepository<Note, Long> {
    Optional<Note> findById(Long id);
}
