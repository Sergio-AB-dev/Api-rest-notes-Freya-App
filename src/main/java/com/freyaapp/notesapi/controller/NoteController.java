package com.freyaapp.notesapi.controller;

import com.freyaapp.notesapi.model.Note;
import com.freyaapp.notesapi.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar las operaciones de los apuntes.
 */
@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    /**
     * Endpoint para crear un nuevo apunte.
     *
     * @param note Objeto Note a crear.
     * @return Apunte creado.
     */
    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        Note createdNote = noteService.createNote(note);
        return ResponseEntity.ok(createdNote);
    }

    /**
     * Endpoint para obtener todos los apuntes.
     *
     * @return Lista de apuntes.
     */
    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        List<Note> notes = noteService.getAllNotes();
        return ResponseEntity.ok(notes);
    }

    /**
     * Endpoint para obtener un apunte por su ID.
     *
     * @param id Identificador del apunte.
     * @return Apunte encontrado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        return noteService.getNoteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Endpoint para actualizar un apunte existente.
     *
     * @param id   Identificador del apunte a actualizar.
     * @param note Datos actualizados del apunte.
     * @return Apunte actualizado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note note) {
        try {
            Note updatedNote = noteService.updateNote(id, note);
            return ResponseEntity.ok(updatedNote);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Endpoint para eliminar un apunte por su ID.
     *
     * @param id Identificador del apunte a eliminar.
     * @return Respuesta sin contenido.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return ResponseEntity.noContent().build();
    }
}
