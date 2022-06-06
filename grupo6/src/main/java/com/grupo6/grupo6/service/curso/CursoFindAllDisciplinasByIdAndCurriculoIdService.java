package com.grupo6.grupo6.service.curso;

import com.grupo6.grupo6.controller.response.DisciplinaResponse;
import com.grupo6.grupo6.domain.Curso;
import com.grupo6.grupo6.domain.Curriculo;
import com.grupo6.grupo6.domain.Disciplina;
import com.grupo6.grupo6.mapper.disciplina.DisciplinaResponseMapper;
import com.grupo6.grupo6.repository.CursoRepository;
import com.grupo6.grupo6.repository.CurriculoRepository;
import com.grupo6.grupo6.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CursoFindAllDisciplinasByIdAndCurriculoIdService {
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private CurriculoRepository curriculoRepository;

    @Autowired
    private DisciplinaResponseMapper disciplinaResponseMapper;

    public List<DisciplinaResponse> execute(String id_curso, String id_curriculo) {
        Optional<Curso> cursoExistente = cursoRepository.getOne(id_curso);
        Curso curso = cursoExistente.get();

        Optional<Curriculo> curriculoExistente = curriculoRepository.getOne(id_curriculo);
        Curriculo curriculo = curriculoExistente.get();

        List<Disciplina> response = disciplinaRepository.findAll();

        return response
            .stream()
            .map(disciplina -> disciplinaResponseMapper.apply(disciplina))
            .collect(Collectors.toList());
    }
}
