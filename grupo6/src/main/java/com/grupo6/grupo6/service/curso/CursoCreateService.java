package com.grupo6.grupo6.service.curso;

import com.grupo6.grupo6.controller.request.CursoRequest;
import com.grupo6.grupo6.controller.response.CursoResponse;
import com.grupo6.grupo6.domain.Curso;
import com.grupo6.grupo6.mapper.curso.CursoRequestMapper;
import com.grupo6.grupo6.mapper.curso.CursoResponseMapper;
import com.grupo6.grupo6.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoCreateService {
    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private CursoRequestMapper cursoRequestMapper;

    @Autowired
    private CursoResponseMapper cursoResponseMapper;

    public CursoResponse execute(CursoRequest request) {
        Curso curso = cursoRequestMapper.apply(request);
        curso = cursoRepository.save(curso);
        return cursoResponseMapper.apply(curso);
    }
}
