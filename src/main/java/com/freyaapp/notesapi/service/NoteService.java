package com.freyaapp.notesapi.service;

import java.util.List;
import java.util.Optional;

import com.freyaapp.notesapi.model.Note;

/**
 * Interfaz de servicio para operaciones CRUD de Note.
 */
public interface NoteService {

    /**
     * Crea un nuevo apunte.
     *
     * @param note Objeto Note a crear.
     * @return Apunte creado.
     */
    Note createNote(Note note);

    /**
     * Obtiene la lista de todos los apuntes.
     *
     * @return Lista de apuntes.
     */
    List<Note> getAllNotes();

    /**
     * Busca un apunte por su ID.
     *
     * @param id Identificador del apunte.
     * @return Optional que contiene el apunte si existe.
     */
    Optional<Note> getNoteById(Long id);

    /**
     * Actualiza un apunte existente.
     *
     * @param id Identificador del apunte a actualizar.
     * @param note Datos del apunte actualizado.
     * @return Apunte actualizado.
     */
    Note updateNote(Long id, Note note);

    /**
     * Elimina un apunte por su ID.
     *
     * @param id Identificador del apunte a eliminar.
     */
    void deleteNote(Long id);
}
