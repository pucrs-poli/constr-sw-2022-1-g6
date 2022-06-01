package com.grupo6.grupo6.repository;


import com.grupo6.grupo6.domain.Curso;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface CursoRepository extends Repository<Curso, String> {
    List<Curso> findAll();
    Curso save(Curso curso);

    Optional<Curso> findById(String idCurso);
}
