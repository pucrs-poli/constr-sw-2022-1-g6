package com.grupo6.grupo6.repository;


import com.grupo6.grupo6.domain.Disciplina;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface DisciplinaRepository extends Repository<Disciplina, Integer> {
    List<Disciplina> findAll();
    Disciplina save(Disciplina disciplina);
}
