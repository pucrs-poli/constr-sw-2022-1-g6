package com.grupo6.grupo6.repository;


import com.grupo6.grupo6.domain.Disciplina;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface DisciplinaRepository extends Repository<Disciplina, String> {
    List<Disciplina> findAll();

    List<Disciplina> findByAtivaTrue();
    Disciplina save(Disciplina disciplina);

    Optional<Disciplina> getOne(String disciplinaId);
    Optional<Disciplina> findById(String disciplinaId);
}
