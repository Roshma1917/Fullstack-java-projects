package com.roshma.notesapi.controller;

import com.roshma.notesapi.dto.NoteRequestDTO;
import com.roshma.notesapi.dto.NoteResponseDTO;
import com.roshma.notesapi.service.NoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

// @RestController = @Controller + @ResponseBody — returns JSON automatically
// @RequestMapping sets the base URL for all endpoints in this controller
@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class NoteController {

    private final NoteService noteService;

    // POST /api/notes — creates a new note
    // @Valid triggers validation annotations on NoteRequestDTO
    @PostMapping
    public ResponseEntity<NoteResponseDTO> createNote(@Valid @RequestBody NoteRequestDTO request) {
        NoteResponseDTO response = noteService.createNote(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // GET /api/notes — returns all notes
    @GetMapping
    public ResponseEntity<List<NoteResponseDTO>> getAllNotes() {
        return ResponseEntity.ok(noteService.getAllNotes());
    }

    // GET /api/notes/{id} — returns one note by ID
    @GetMapping("/{id}")
    public ResponseEntity<NoteResponseDTO> getNoteById(@PathVariable Long id) {
        return ResponseEntity.ok(noteService.getNoteById(id));
    }

    // PUT /api/notes/{id} — updates an existing note
    @PutMapping("/{id}")
    public ResponseEntity<NoteResponseDTO> updateNote(
            @PathVariable Long id,
            @Valid @RequestBody NoteRequestDTO request) {
        return ResponseEntity.ok(noteService.updateNote(id, request));
    }

    // DELETE /api/notes/{id} — deletes a note, returns 204 No Content
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return ResponseEntity.noContent().build();
    }
}