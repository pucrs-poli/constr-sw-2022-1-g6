package com.grupo6.grupo6.mapper.curriculo;

import com.grupo6.grupo6.controller.request.CurriculoRequest;
import com.grupo6.grupo6.domain.Curriculo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CurriculoRequestMapper {
    @Autowired
    private ModelMapper modelMapper;

    public Curriculo apply(CurriculoRequest request) {
     return modelMapper.map(request, Curriculo.class);
    }
}
