package com.fittrack.fittrack.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fittrack.fittrack.dto.ExerciseDTO;
import com.fittrack.fittrack.dto.ExerciseListDTO;
import com.fittrack.fittrack.dto.ExerciseUpdateDTO;
import com.fittrack.fittrack.repository.ExerciseRepository;
import com.fittrack.fittrack.repository.entity.Exercise;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/exercises")
public class ExerciseController {

    @Autowired
    private ExerciseRepository repository;

    @PostMapping
    @Transactional
    public void createExercise(@RequestBody @Valid ExerciseDTO data) {
        repository.save(new Exercise(data));
    }

    @GetMapping
    public List<ExerciseListDTO> getExercises() {
        return repository.findAll().stream().map(ExerciseListDTO::new).toList();
    }

    @PutMapping("/{id}")
    @Transactional
    public void updateExercise(@PathVariable Long id, @RequestBody @Valid ExerciseUpdateDTO data) {
        var exercise = repository.findById(id).orElseThrow(() -> new RuntimeException("Exercise not found."));
        exercise.update(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteExercise(@PathVariable Long id) {
        var exercise = repository.findById(id).orElseThrow(() -> new RuntimeException("Exercise not found."));
        repository.delete(exercise);
    }

}
