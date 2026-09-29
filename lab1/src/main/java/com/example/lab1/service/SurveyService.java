package com.example.lab1.service;

import com.example.lab1.dto.SurveyDto;
import com.example.lab1.entity.Survey;
import com.example.lab1.mapper.SurveyMapper;
import com.example.lab1.repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SurveyService {
    private final SurveyRepository repository;
    private final SurveyMapper mapper;

    public List<SurveyDto> getAllSurveys() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public SurveyDto createSurvey(SurveyDto dto) {
        Survey entity = mapper.toEntity(dto);
        Survey saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void deleteSurvey(Long id) {
        repository.deleteById(id);
    }
}