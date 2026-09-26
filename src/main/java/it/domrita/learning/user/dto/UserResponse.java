package it.domrita.learning.user.dto;

import jakarta.validation.constraints.NotNull;

public record UserResponse(
        Long id,
        String name,
        String email
) {
}
