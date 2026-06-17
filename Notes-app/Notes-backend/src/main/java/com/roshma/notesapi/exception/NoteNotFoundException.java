package com.roshma.notesapi.exception;

// Custom exception thrown when a note ID doesn't exist in the database
public class NoteNotFoundException extends RuntimeException {

    public NoteNotFoundException(String message) {
        super(message);
    }
}