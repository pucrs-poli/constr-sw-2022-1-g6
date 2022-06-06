package com.grupo6.grupo6.service.curriculo;

import com.grupo6.grupo6.controller.request.CurriculoRequest;
import com.grupo6.grupo6.controller.response.CurriculoResponse;
import com.grupo6.grupo6.domain.Curriculo;
import com.grupo6.grupo6.domain.Curso;
import com.grupo6.grupo6.mapper.curriculo.CurriculoRequestMapper;
import com.grupo6.grupo6.mapper.curriculo.CurriculoResponseMapper;
import com.grupo6.grupo6.repository.CurriculoRepository;
import com.grupo6.grupo6.repository.CursoRepository;
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
    private CurriculoRequestMapper curriculoRequestMapper;

    @Autowired
    private CurriculoResponseMapper curriculoResponseMapper;

    public CurriculoResponse execute(CurriculoRequest request, String idCurso) {
        Curriculo novoCurriculo = curriculoRequestMapper.apply(request);
        Optional<Curso> cursoExistente = cursoRepository.getOne(idCurso);
        Curso curso = cursoExistente.get();
        novoCurriculo.setCurso(curso);
        novoCurriculo = curriculoRepository.save(novoCurriculo);

        return curriculoResponseMapper.apply(novoCurriculo);
    }
}
