package com.grupo6.grupo6.controller;

import com.grupo6.grupo6.controller.request.CurriculoRequest;
import com.grupo6.grupo6.controller.request.CursoRequest;
import com.grupo6.grupo6.controller.response.CurriculoResponse;
import com.grupo6.grupo6.controller.response.CursoResponse;
import com.grupo6.grupo6.service.curriculo.CurriculoCreateService;
import com.grupo6.grupo6.service.curriculo.CurriculoFindAllService;
import com.grupo6.grupo6.service.curso.CursoCreateService;
import com.grupo6.grupo6.service.curso.CursoFindAllService;
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
    public List<CurriculoResponse> create(@PathVariable String id) {
        return curriculoFindAllService.execute(id);
    }
}
