package com.grupo6.grupo6.mapper.disciplina;

import com.grupo6.grupo6.controller.request.DisciplinaRequest;
import com.grupo6.grupo6.domain.Disciplina;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DisciplinaRequestMapper {
    @Autowired
    private ModelMapper modelMapper;

    public Disciplina apply(DisciplinaRequest request) {
     return modelMapper.map(request, Disciplina.class);
    }
}
