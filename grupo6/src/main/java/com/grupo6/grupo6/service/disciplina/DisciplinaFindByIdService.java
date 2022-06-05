package com.grupo6.grupo6.service.disciplina;

import com.grupo6.grupo6.controller.response.DisciplinaResponse;
import com.grupo6.grupo6.domain.Disciplina;
import com.grupo6.grupo6.mapper.disciplina.DisciplinaResponseMapper;
import com.grupo6.grupo6.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DisciplinaFindByIdService {
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private DisciplinaResponseMapper disciplinaResponseMapper;

    public DisciplinaResponse execute(String idDisciplina) {
        Optional<Disciplina> disciplinaExistente = disciplinaRepository.getOne(idDisciplina);
        Disciplina disciplina = disciplinaExistente.get();
        return disciplinaResponseMapper.apply(disciplina);
    }
}
