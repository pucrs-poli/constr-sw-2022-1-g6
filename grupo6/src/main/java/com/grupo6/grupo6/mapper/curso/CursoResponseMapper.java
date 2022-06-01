package com.grupo6.grupo6.mapper.curso;

import com.grupo6.grupo6.controller.response.CursoResponse;
import com.grupo6.grupo6.domain.Curso;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CursoResponseMapper {
    @Autowired
    private ModelMapper modelMapper;

    public CursoResponse apply(Curso curso) {
        return modelMapper.map(curso, CursoResponse.class);
    }
}
