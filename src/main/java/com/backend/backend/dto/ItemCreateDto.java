package com.backend.backend.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemCreateDto {
    private Long id;
    @Size(min=5, max=50, message = "Name must be between 5 and 50 characters")
    @NotNull(message = "Name cannot be null")
    private String name;
    @Size(max=200, message = "Description must be up to 200 characters")
    private String description;
}
