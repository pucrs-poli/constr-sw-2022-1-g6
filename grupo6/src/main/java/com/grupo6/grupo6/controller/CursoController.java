package com.grupo6.grupo6.controller;

import com.grupo6.grupo6.controller.request.CursoRequest;
import com.grupo6.grupo6.controller.request.CurriculoRequest;
import com.grupo6.grupo6.controller.request.DisciplinaRequest;
import com.grupo6.grupo6.controller.response.CursoResponse;
import com.grupo6.grupo6.controller.response.CurriculoResponse;
import com.grupo6.grupo6.controller.response.DisciplinaResponse;
import com.grupo6.grupo6.service.curriculo.CurriculoCreateService;
import com.grupo6.grupo6.service.curriculo.CurriculoFindAllService;
import com.grupo6.grupo6.service.curriculo.CurriculoUpdateByCursoIdService;
import com.grupo6.grupo6.service.curso.CursoCreateService;
import com.grupo6.grupo6.service.curso.CursoFindAllService;
import com.grupo6.grupo6.service.curso.CursoFindAllDisciplinasByIdAndCurriculoIdService;
import com.grupo6.grupo6.service.curso.CursoFindByIdService;
import com.grupo6.grupo6.service.curso.CursoUpdateByIdService;
import com.grupo6.grupo6.service.curso.DeleteDiscipinaByCursoAndCurriculoIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cursos")
public class CursoController {
    @Autowired
    private CursoFindAllService cursoFindAllService;

    @Autowired
    private CursoCreateService cursoCreateService;

    @Autowired
    private CurriculoCreateService curriculoCreateService;

    @Autowired
    private CurriculoFindAllService curriculoFindAllService;
    
    //GET cursos/{id_curso}: recupera um curso com base no deu ID
    @Autowired
    private CursoFindByIdService cursoFindByIdService;

    //GET cursos/{id_curso}/curriculos/{id_curriculo}/disciplinas: listagem das disciplinas de um determinado currículo e de um determinado curso.
    @Autowired
    private CursoFindAllDisciplinasByIdAndCurriculoIdService cursoFindAllDisciplinasByIdAndCurriculoIdService;

    //PUT cursos/{id_curso}: altera um determinado curso
    @Autowired
    private CursoUpdateByIdService cursoUpdateByIdService;

    //PUT cursos/{id_curso}/curriculos/{id_curriculo}: altera um currículo de um determinado curso, baseado no seu ID.
    @Autowired
    private CurriculoUpdateByCursoIdService curriculoUpdateByCursoIdService;

    //DELETE /cursos/{id_curso}/curriculos/{id_curriculo}/disciplinas/{id_disciplina}: exclusão lógica de uma disciplina que está vinculada a um determinado currículo e a um determinado curso.
    @Autowired
    private DeleteDiscipinaByCursoAndCurriculoIdService deleteDiscipinaByCursoAndCurriculoIdService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CursoResponse> findAll() {
        return cursoFindAllService.execute();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public CursoResponse create(@RequestBody CursoRequest request) {
        return cursoCreateService.execute(request);
    }

    @PostMapping("{id}/curriculos")
    @ResponseStatus(HttpStatus.OK)
    public CurriculoResponse create(@PathVariable String id, @RequestBody CurriculoRequest request) {
        return curriculoCreateService.execute(request, id);
    }

    @GetMapping("{id}/curriculos")
    @ResponseStatus(HttpStatus.OK)
    public List<CurriculoResponse> listAll(@PathVariable String id) {
        return curriculoFindAllService.execute(id);
    }

    @GetMapping("cursos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CursoResponse findById(@PathVariable String id) {
        return cursoFindByIdService.execute(id);
    }

    @GetMapping("cursos/{id_curso}/curriculos/{id_curriculo}/disciplinas")
    @ResponseStatus(HttpStatus.OK)
    public List<DisciplinaResponse> listAllDisciplinasByCursoAndCurriculoId(@PathVariable String id_curso, @PathVariable String id_curriculo) {
        return cursoFindAllDisciplinasByIdAndCurriculoIdService.execute(id_curso, id_curriculo);
    }

    @PutMapping("cursos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CursoResponse updateCursoById(@PathVariable String id, @RequestBody CursoRequest request) {
        return cursoUpdateByIdService.execute(id, request);
    }

    @PutMapping("cursos/{id_curso}/Curriculo/{id_curriculo}")
    @ResponseStatus(HttpStatus.OK)
    public CurriculoResponse updateCurriculoByCursoId(@PathVariable String id_curso, @PathVariable String id_curriculo, @RequestBody CurriculoRequest request) {
        return curriculoUpdateByCursoIdService.execute(id_curso, id_curriculo, request);
    }

    @DeleteMapping("cursos/{id_curso}/curriculos/{id_curriculo}/disciplinas/{id_disciplina}")
    public void deleteDisciplinaById(@PathVariable String id_curso, @PathVariable String id_curriculo, @PathVariable String id_disciplina) {
        deleteDiscipinaByCursoAndCurriculoIdService.execute(id_curso, id_curriculo, id_disciplina);
    }
}
