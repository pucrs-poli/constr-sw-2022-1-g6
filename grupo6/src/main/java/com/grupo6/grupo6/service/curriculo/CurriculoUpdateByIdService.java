package com.grupo6.grupo6.service.curriculo;

import com.grupo6.grupo6.controller.request.CurriculoRequest;
import com.grupo6.grupo6.controller.response.CurriculoResponse;
import com.grupo6.grupo6.domain.Curriculo;
import com.grupo6.grupo6.domain.Curso;
import com.grupo6.grupo6.mapper.curriculo.CurriculoRequestMapper;
import com.grupo6.grupo6.mapper.curriculo.CurriculoResponseMapper;
import com.grupo6.grupo6.repository.CurriculoRepository;
import com.grupo6.grupo6.repository.CursoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CurriculoUpdateByIdService {
    @Autowired
    private CursoRepository cursoRepository;
    
    @Autowired
    private CurriculoRepository curriculoRepository;

    @Autowired
    private CurriculoResponseMapper curriculoResponseMapper;

    @Autowired
    private CurriculoRequestMapper curriculoRequestMapper;

    public CurriculoResponse execute(String idCurriculo, CurriculoRequest request) {
        Curriculo curriculoEncontrado = curriculoRepository.getOne(idCurriculo)
                .orElse(new Curriculo());

        curriculoEncontrado.setNome(request.getNome());

        curriculoEncontrado = curriculoRepository.save(curriculoEncontrado);

        return curriculoResponseMapper.apply(curriculoEncontrado);
    }
}
