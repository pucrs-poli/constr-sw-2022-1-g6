package com.grupo6.grupo6.service.curso;

import com.grupo6.grupo6.controller.response.CursoResponse;
import com.grupo6.grupo6.domain.Curso;
import com.grupo6.grupo6.mapper.curso.CursoResponseMapper;
import com.grupo6.grupo6.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FindAllService {
    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private CursoResponseMapper cursoResponseMapper;

    public List<CursoResponse> execute() {
     List<Curso> response = cursoRepository.findAll();

     return response
         .stream()
         .map(curso -> cursoResponseMapper.apply(curso))
         .collect(Collectors.toList());
    }
}
