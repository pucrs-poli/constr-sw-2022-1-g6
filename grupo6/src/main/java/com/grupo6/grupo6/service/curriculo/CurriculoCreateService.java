package com.grupo6.grupo6.service.curriculo;

import com.grupo6.grupo6.controller.request.CurriculoRequest;
import com.grupo6.grupo6.controller.response.CurriculoResponse;
import com.grupo6.grupo6.controller.response.CursoResponse;
import com.grupo6.grupo6.domain.Curriculo;
import com.grupo6.grupo6.domain.Curso;
import com.grupo6.grupo6.mapper.curriculo.CurriculoRequestMapper;
import com.grupo6.grupo6.mapper.curriculo.CurriculoResponseMapper;
import com.grupo6.grupo6.mapper.curso.CursoResponseMapper;
import com.grupo6.grupo6.repository.CurriculoRepository;
import com.grupo6.grupo6.repository.CursoRepository;
import com.grupo6.grupo6.service.curso.CursoFindByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CurriculoCreateService {
    @Autowired
    private CurriculoRepository curriculoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private CursoResponseMapper cursoResponseMapper;

    @Autowired
    private CursoFindByIdService cursoFindByIdService;

    @Autowired
    private CurriculoRequestMapper curriculoRequestMapper;

    @Autowired
    private CurriculoResponseMapper curriculoResponseMapper;

    public CurriculoResponse execute(CurriculoRequest request, String idCurso) {
        Curriculo novoCurriculo = curriculoRequestMapper.apply(request);
        Curso cursoEncontrado = cursoRepository.getOne(idCurso)
                .orElse(new Curso());
        cursoEncontrado.getCurriculos().add(novoCurriculo);
        novoCurriculo = curriculoRepository.save(novoCurriculo);
        return curriculoResponseMapper.apply(novoCurriculo);
    }
}
