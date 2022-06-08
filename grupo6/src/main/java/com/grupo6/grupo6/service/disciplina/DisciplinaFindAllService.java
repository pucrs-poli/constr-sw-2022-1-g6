package com.grupo6.grupo6.service.disciplina;

import com.grupo6.grupo6.controller.response.DisciplinaResponse;
import com.grupo6.grupo6.domain.Disciplina;
import com.grupo6.grupo6.mapper.disciplina.DisciplinaResponseMapper;
import com.grupo6.grupo6.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DisciplinaFindAllService {
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private DisciplinaResponseMapper disciplinaResponseMapper;

    public List<DisciplinaResponse> execute(boolean onlyActives) {
        List<Disciplina> response;

        if (onlyActives) {
            response = disciplinaRepository.findByAtivaTrue();
        } else {
            response = disciplinaRepository.findAll();
        }

     return response
         .stream()
         .map(disciplina -> disciplinaResponseMapper.apply(disciplina))
         .collect(Collectors.toList());
    }
}
