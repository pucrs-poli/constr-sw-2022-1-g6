package com.grupo6.grupo6.service.curso;

import com.grupo6.grupo6.controller.response.CursoResponse;
import com.grupo6.grupo6.domain.Curso;
import com.grupo6.grupo6.mapper.curso.CursoResponseMapper;
import com.grupo6.grupo6.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CursoFindByIdService {
    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private CursoResponseMapper cursoResponseMapper;

    public CursoResponse execute(String idCurso) {
        Curso cursoExistente = cursoRepository.getOne(idCurso).orElse(new Curso());
        return cursoResponseMapper.apply(cursoExistente);
    }
}
