package com.grupo6.grupo6.service.curriculo;

import com.grupo6.grupo6.controller.request.CurriculoRequest;
import com.grupo6.grupo6.controller.response.CurriculoResponse;
import com.grupo6.grupo6.domain.Curriculo;
import com.grupo6.grupo6.mapper.curriculo.CurriculoResponseMapper;
import com.grupo6.grupo6.repository.CurriculoRepository;
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
    private ModelMapper modelMapper;

    public CurriculoResponse execute(String id_curso, String id_curriculo, CurriculoRequest request) {
        Curriculo curriculo = modelMapper.map(request, Curriculo.class);
        Curso cursoExistente = cursoRepository.findById(id_curso);
        Curso curso = cursoExistente.get();
        curriculo.setCurso(curso);
        curriculo.setId(id_curriculo);
        Curriculo curriculoAtualizada =  curriculoRepository.save(curriculo);
        return curriculoResponseMapper.apply(curriculoAtualizada);
    }
}
