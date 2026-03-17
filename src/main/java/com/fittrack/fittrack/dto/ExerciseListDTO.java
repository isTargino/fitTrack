package com.fittrack.fittrack.dto;

import com.fittrack.fittrack.enums.MuscleGroup;
import com.fittrack.fittrack.repository.entity.Exercise;

public record ExerciseListDTO(
    Long id,
    String name,
    MuscleGroup muscleGroup,
    String description) {

        public ExerciseListDTO(Exercise exercise) {
            this(
                exercise.getId(),
                exercise.getName(), 
                exercise.getMuscleGroup(),
                exercise.getDescription());
        }
}
