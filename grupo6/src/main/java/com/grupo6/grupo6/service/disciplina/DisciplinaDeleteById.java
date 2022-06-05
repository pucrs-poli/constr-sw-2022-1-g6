package com.grupo6.grupo6.service.disciplina;

import com.grupo6.grupo6.domain.Disciplina;
import com.grupo6.grupo6.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DisciplinaDeleteById {
    @Autowired
    DisciplinaRepository disciplinaRepository;

    public void execute(String idDisciplina) {
        Optional<Disciplina> disciplinaExistente = disciplinaRepository.getOne(idDisciplina);
        Disciplina disciplina = disciplinaExistente.get();

        disciplina.setAtiva(false);
        disciplinaRepository.save(disciplina);
    }
}
