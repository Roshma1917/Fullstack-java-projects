package com.roshma.notesapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

// This is what the CLIENT sends TO us when creating or updating a note
@Data
public class NoteRequestDTO {

    // @NotBlank means this field cannot be null or empty string
    @NotBlank(message = "Title cannot be blank")
    // @Size limits how long the title can be
    @Size(max = 255, message = "Title cannot exceed 255 characters")
    private String title;

    // @NotBlank ensures content is always provided
    @NotBlank(message = "Content cannot be blank")
    private String content;
}