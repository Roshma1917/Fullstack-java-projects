package com.roshma.notesapi.service;

import com.roshma.notesapi.dto.NoteRequestDTO;
import com.roshma.notesapi.dto.NoteResponseDTO;

import java.util.List;

// Interface defines the CONTRACT — what operations are available
// The implementation class provides the actual logic
public interface NoteService {

    NoteResponseDTO createNote(NoteRequestDTO request);

    List<NoteResponseDTO> getAllNotes();

    NoteResponseDTO getNoteById(Long id);

    NoteResponseDTO updateNote(Long id, NoteRequestDTO request);

    void deleteNote(Long id);
}