package com.grupo6.grupo6.service.curriculo;

import com.grupo6.grupo6.controller.response.CurriculoResponse;
import com.grupo6.grupo6.domain.Curriculo;
import com.grupo6.grupo6.domain.Curso;
import com.grupo6.grupo6.mapper.curriculo.CurriculoResponseMapper;
import com.grupo6.grupo6.repository.CurriculoRepository;
import com.grupo6.grupo6.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CurriculoFindAllService {
    @Autowired
    private CurriculoRepository curriculoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private CurriculoResponseMapper curriculoResponseMapper;

    public List<CurriculoResponse> execute(String idCurso) {
     Optional<Curso> cursoExistente = cursoRepository.getOne(idCurso);

     Curso curso = cursoExistente.get();

     return curso.getCurriculos()
         .stream()
         .map(curriculo -> curriculoResponseMapper.apply(curriculo))
         .collect(Collectors.toList());
    }
}
