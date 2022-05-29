package com.grupo6.grupo6.repository;


import com.grupo6.grupo6.domain.Curriculo;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface CurriculoRepository extends Repository<Curriculo, String> {
    List<Curriculo> findAll();
    Curriculo save(Curriculo curriculo);
}
