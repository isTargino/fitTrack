package com.fittrack.fittrack.dto;

import com.fittrack.fittrack.enums.MuscleGroup;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

public record ExerciseDTO(
    @NotBlank
    String name,

    @Enumerated
    MuscleGroup muscleGroup,

    String description) {

}
