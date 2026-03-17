package com.fittrack.fittrack.repository.entity;

import com.fittrack.fittrack.dto.ExerciseDTO;
import com.fittrack.fittrack.dto.ExerciseUpdateDTO;
import com.fittrack.fittrack.enums.MuscleGroup;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "exercise")
@Table(name = "exercises")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Exercise {

    public Exercise(ExerciseDTO data) {
        this.name = data.name();
        this.muscleGroup = data.muscleGroup();
        this.description = data.description();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private MuscleGroup muscleGroup;

    private String description;

    public void update(@Valid ExerciseUpdateDTO data) {
        if(data.description() != null) {
            this.description = data.description();
        }
    }
}
