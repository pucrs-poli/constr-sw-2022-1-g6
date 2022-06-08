package com.grupo6.grupo6.controller;

import com.grupo6.grupo6.controller.request.CurriculoRequest;
import com.grupo6.grupo6.controller.response.CurriculoResponse;
import com.grupo6.grupo6.controller.response.DisciplinaResponse;
import com.grupo6.grupo6.service.curriculo.CurriculoUpdateByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("curriculos")
public class CurriculoController {

    @Autowired
    private CurriculoUpdateByIdService curriculoUpdateByIdService;

    // Lista as disciplinas de um determinado currículo
    @GetMapping("{id_curriculo}/disciplinas")
    @ResponseStatus(HttpStatus.OK)
    public List<DisciplinaResponse> listAllDisciplinasByCursoAndCurriculoId(@PathVariable String id_curso, @PathVariable String id_curriculo) {
        //TODO: implementar
        return null;
    }

    // Exclusão lógica de uma disciplina associada a um curso
    @DeleteMapping("{id_curriculo}/disciplinas/{id_disciplina}")
    public void deleteDisciplinaById(@PathVariable String id_curso, @PathVariable String id_curriculo, @PathVariable String id_disciplina) {
        //TODO: implementar
    }

    // Atualiza um currículo, baseado no seu ID
    @PutMapping("{idCurriculo}")
    @ResponseStatus(HttpStatus.OK)
    public CurriculoResponse updateCurriculoByCursoId(@PathVariable String idCurriculo, @RequestBody CurriculoRequest request) {
        return curriculoUpdateByIdService.execute(idCurriculo, request);
    }
}
