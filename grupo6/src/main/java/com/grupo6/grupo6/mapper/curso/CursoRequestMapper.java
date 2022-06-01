package com.grupo6.grupo6.mapper.curso;

import com.grupo6.grupo6.controller.request.CursoRequest;
import com.grupo6.grupo6.domain.Curso;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CursoRequestMapper {
    @Autowired
    private ModelMapper modelMapper;

    public Curso apply(CursoRequest request) {
     return modelMapper.map(request, Curso.class);
    }
}
