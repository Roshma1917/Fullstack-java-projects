package com.roshma.notesapi.service;

import com.roshma.notesapi.dto.NoteRequestDTO;
import com.roshma.notesapi.dto.NoteResponseDTO;
import com.roshma.notesapi.entity.Note;
import com.roshma.notesapi.exception.NoteNotFoundException;
import com.roshma.notesapi.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// @Service marks this as a business logic component
// @RequiredArgsConstructor generates constructor injection for all final fields
@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    // Spring injects this automatically via constructor
    private final NoteRepository noteRepository;

    // Converts request DTO to entity, saves it, returns response DTO
    @Override
    public NoteResponseDTO createNote(NoteRequestDTO request) {
        Note note = Note.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();

        Note saved = noteRepository.save(note);
        return mapToResponse(saved);
    }

    // Fetches all notes and converts each to response DTO
    @Override
    public List<NoteResponseDTO> getAllNotes() {
        return noteRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // Finds note by ID or throws exception if not found
    @Override
    public NoteResponseDTO getNoteById(Long id) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException("Note not found with id: " + id));
        return mapToResponse(note);
    }

    // Updates existing note fields and saves
    @Override
    public NoteResponseDTO updateNote(Long id, NoteRequestDTO request) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException("Note not found with id: " + id));

        note.setTitle(request.getTitle());
        note.setContent(request.getContent());

        Note updated = noteRepository.save(note);
        return mapToResponse(updated);
    }

    // Deletes note by ID or throws exception if not found
    @Override
    public void deleteNote(Long id) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException("Note not found with id: " + id));
        noteRepository.delete(note);
    }

    // Private helper — converts Note entity to NoteResponseDTO
    private NoteResponseDTO mapToResponse(Note note) {
        return NoteResponseDTO.builder()
                .id(note.getId())
                .title(note.getTitle())
                .content(note.getContent())
                .createdAt(note.getCreatedAt())
                .updatedAt(note.getUpdatedAt())
                .build();
    }
}