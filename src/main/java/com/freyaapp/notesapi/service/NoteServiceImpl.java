package com.freyaapp.notesapi.service;

import com.freyaapp.notesapi.model.Note;
import com.freyaapp.notesapi.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementación del servicio para gestionar operaciones CRUD de apuntes.
 */
@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Note createNote(Note note) {
        // Se establece la fecha de creación si no está definida
        if (note.getCreatedAt() == null) {
            note.setCreatedAt(java.time.LocalDateTime.now());
        }
        return noteRepository.save(note);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Note> getNoteById(Long id) {
        return noteRepository.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Note updateNote(Long id, Note note) {
        return noteRepository.findById(id).map(existingNote -> {
            existingNote.setTitle(note.getTitle());
            existingNote.setContent(note.getContent());
            return noteRepository.save(existingNote);
        }).orElseThrow(() -> new RuntimeException("Note not found with id " + id));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }
}
