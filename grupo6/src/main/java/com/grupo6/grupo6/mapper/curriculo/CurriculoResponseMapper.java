package com.grupo6.grupo6.mapper.curriculo;

import com.grupo6.grupo6.controller.response.CurriculoResponse;
import com.grupo6.grupo6.domain.Curriculo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CurriculoResponseMapper {
    @Autowired
    private ModelMapper modelMapper;

    public CurriculoResponse apply(Curriculo curriculo) {
        return modelMapper.map(curriculo, CurriculoResponse.class);
    }
}
