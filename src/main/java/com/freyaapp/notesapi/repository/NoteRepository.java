package com.freyaapp.notesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freyaapp.notesapi.model.Note;

/**
 * Repositorio para la entidad Note, que provee operaciones CRUD.
 */
@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    // Métodos CRUD ya están disponibles a través de JpaRepository
}
