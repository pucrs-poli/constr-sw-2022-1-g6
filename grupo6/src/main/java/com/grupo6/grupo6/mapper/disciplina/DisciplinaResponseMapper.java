package com.grupo6.grupo6.mapper.disciplina;

import com.grupo6.grupo6.controller.response.DisciplinaResponse;
import com.grupo6.grupo6.domain.Disciplina;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DisciplinaResponseMapper {
    @Autowired
    private ModelMapper modelMapper;

    public DisciplinaResponse apply(Disciplina disciplina) {
        return modelMapper.map(disciplina, DisciplinaResponse.class);
    }
}
