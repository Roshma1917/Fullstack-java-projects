package com.roshma.notesapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

// @Entity tells JPA this class maps to a database table
@Entity
// @Table specifies the exact table name in PostgreSQL
@Table(name = "notes")
// Lombok annotations — generate getters, setters, constructors automatically
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Note {

    // @Id marks this as the primary key
    @Id
    // @GeneratedValue tells PostgreSQL to auto-increment this
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column adds constraints at the database level
    @Column(nullable = false, length = 255)
    private String title;

    // columnDefinition = "TEXT" allows unlimited length content
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    // @CreationTimestamp sets this automatically when record is created
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // @UpdateTimestamp updates this automatically on every save
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}