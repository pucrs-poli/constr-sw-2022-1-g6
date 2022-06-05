package com.grupo6.grupo6.service.disciplina;

import com.grupo6.grupo6.controller.request.DisciplinaRequest;
import com.grupo6.grupo6.controller.response.DisciplinaResponse;
import com.grupo6.grupo6.domain.Disciplina;
import com.grupo6.grupo6.mapper.disciplina.DisciplinaResponseMapper;
import com.grupo6.grupo6.repository.DisciplinaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DisciplinaUpdateByIdService {
    @Autowired
    DisciplinaRepository disciplinaRepository;

    @Autowired
    DisciplinaResponseMapper disciplinaResponseMapper;

    @Autowired
    ModelMapper modelMapper;

    public DisciplinaResponse execute(String id, DisciplinaRequest request) {
        Disciplina disciplina = modelMapper.map(request, Disciplina.class);
        disciplina.setId(id);
        Disciplina disciplinaAtualizada =  disciplinaRepository.save(disciplina);
        return disciplinaResponseMapper.apply(disciplinaAtualizada);
    }
}
