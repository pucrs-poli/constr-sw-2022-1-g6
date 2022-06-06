package com.grupo6.grupo6.service.curso;

import com.grupo6.grupo6.controller.request.CursoRequest;
import com.grupo6.grupo6.controller.response.CursoResponse;
import com.grupo6.grupo6.domain.Curso;
import com.grupo6.grupo6.mapper.curso.CursoResponseMapper;
import com.grupo6.grupo6.repository.CursoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CursoUpdateByIdService {
    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private CursoResponseMapper cursoResponseMapper;

    @Autowired
    private ModelMapper modelMapper;

    public CursoResponse execute(String id, CursoRequest request) {
        Curso curso = modelMapper.map(request, Curso.class);
        curso.setId(id);
        Curso cursoAtualizada =  cursoRepository.save(curso);
        return cursoResponseMapper.apply(cursoAtualizada);
    }
}
