package com.roshma.notesapi.repository;

import com.roshma.notesapi.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// @Repository marks this as a data access component
@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    // Spring Data JPA generates the SQL for this automatically
    // just from the method name — no SQL needed
    List<Note> findByTitleContainingIgnoreCase(String keyword);
}