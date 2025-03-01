package com.freyaapp.notesapi.model;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entidad que representa un apunte en la aplicación Freya-app.
 */
@Entity
@Table(name = "notes")
@Data // Lombok genera getters, setters, toString, equals y hashCode
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    // Constructor por defecto
    public Note() {
        this.createdAt = LocalDateTime.now();
    }
}