package com.roshma.notesapi.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

// This is what WE send BACK to the client after every operation
@Data
@Builder
public class NoteResponseDTO {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}