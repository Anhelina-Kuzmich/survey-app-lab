package com.example.lab1.mapper;

import com.example.lab1.dto.SurveyDto;
import com.example.lab1.entity.Survey;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SurveyMapper {
    SurveyDto toDto(Survey survey);
    Survey toEntity(SurveyDto surveyDto);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(SurveyDto dto, @MappingTarget Survey entity);
}