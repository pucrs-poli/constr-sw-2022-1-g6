package com.grupo6.grupo6.controller;

import com.grupo6.grupo6.controller.request.CursoRequest;
import com.grupo6.grupo6.controller.request.CurriculoRequest;
import com.grupo6.grupo6.controller.response.CursoResponse;
import com.grupo6.grupo6.controller.response.CurriculoResponse;
import com.grupo6.grupo6.service.curriculo.CurriculoCreateService;
import com.grupo6.grupo6.service.curriculo.CurriculoFindAllService;
import com.grupo6.grupo6.service.curso.CursoCreateService;
import com.grupo6.grupo6.service.curso.CursoFindAllService;
import com.grupo6.grupo6.service.curso.CursoFindByIdService;
import com.grupo6.grupo6.service.curso.CursoUpdateByIdService;
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
    
    @Autowired
    private CursoFindByIdService cursoFindByIdService;

    @Autowired
    private CursoUpdateByIdService cursoUpdateByIdService;

    // Retorna todos os cursos
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CursoResponse> findAll() {
        return cursoFindAllService.execute();
    }

    // Cria um novo curso
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public CursoResponse create(@RequestBody CursoRequest request) {
        return cursoCreateService.execute(request);
    }

    // Cria um novo curriculo associado a um curso
    @PostMapping("{id}/curriculos")
    @ResponseStatus(HttpStatus.OK)
    public CurriculoResponse create(@PathVariable String id, @RequestBody CurriculoRequest request) {
        return curriculoCreateService.execute(request, id);
    }

    // Lista os curr??culos de um determinado curso
    @GetMapping("{id}/curriculos")
    @ResponseStatus(HttpStatus.OK)
    public List<CurriculoResponse> listAll(@PathVariable String id) {
        return curriculoFindAllService.execute(id);
    }

    // Retorna um curso baseado no ID
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public CursoResponse findById(@PathVariable String id) {
        return cursoFindByIdService.execute(id);
    }

    // Atualiza todos os dados de um determinado curso
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public CursoResponse updateCursoById(@PathVariable String id, @RequestBody CursoRequest request) {
        return cursoUpdateByIdService.execute(id, request);
    }
}
