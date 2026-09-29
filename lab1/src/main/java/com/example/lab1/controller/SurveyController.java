package com.example.lab1.controller;

import com.example.lab1.dto.SurveyDto;
import com.example.lab1.service.SurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/surveys")
@RequiredArgsConstructor
public class SurveyController {
    private final SurveyService service;

    @GetMapping
    public List<SurveyDto> getAll() {
        return service.getAllSurveys();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SurveyDto create(@RequestBody SurveyDto dto) {
        return service.createSurvey(dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.deleteSurvey(id);
    }
}