package com.grupo6.grupo6.service.curriculo;

import com.grupo6.grupo6.controller.request.CurriculoRequest;
import com.grupo6.grupo6.controller.response.CurriculoResponse;
import com.grupo6.grupo6.domain.Curriculo;
import com.grupo6.grupo6.mapper.curriculo.CurriculoRequestMapper;
import com.grupo6.grupo6.mapper.curriculo.CurriculoResponseMapper;
import com.grupo6.grupo6.repository.CurriculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateService {
    @Autowired
    private CurriculoRepository curriculoRepository;

    @Autowired
    private CurriculoRequestMapper curriculoRequestMapper;

    @Autowired
    private CurriculoResponseMapper curriculoResponseMapper;

    public CurriculoResponse execute(CurriculoRequest request) {
        Curriculo curriculo = curriculoRequestMapper.apply(request);
        curriculo = curriculoRepository.save(curriculo);
        return curriculoResponseMapper.apply(curriculo);
    }
}
