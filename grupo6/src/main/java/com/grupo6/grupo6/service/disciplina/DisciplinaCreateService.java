package com.grupo6.grupo6.service.disciplina;

import com.grupo6.grupo6.controller.request.DisciplinaRequest;
import com.grupo6.grupo6.controller.response.DisciplinaResponse;
import com.grupo6.grupo6.domain.Disciplina;
import com.grupo6.grupo6.mapper.disciplina.DisciplinaRequestMapper;
import com.grupo6.grupo6.mapper.disciplina.DisciplinaResponseMapper;
import com.grupo6.grupo6.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisciplinaCreateService {
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private DisciplinaRequestMapper disciplinaRequestMapper;

    @Autowired
    private DisciplinaResponseMapper disciplinaResponseMapper;

    public DisciplinaResponse execute(DisciplinaRequest request) {
        Disciplina disciplina = disciplinaRequestMapper.apply(request);
        disciplina = disciplinaRepository.save(disciplina);
        return disciplinaResponseMapper.apply(disciplina);
    }
}
