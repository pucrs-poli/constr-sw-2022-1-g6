package com.grupo6.grupo6.controller;

import com.grupo6.grupo6.controller.request.DisciplinaRequest;
import com.grupo6.grupo6.controller.response.DisciplinaResponse;
import com.grupo6.grupo6.service.disciplina.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("disciplinas")
public class DisciplinaController {
    @Autowired
    private DisciplinaFindAllService disciplinaFindAllService;

    @Autowired
    private DisciplinaCreateService disciplinaCreateService;

    @Autowired
    private DisciplinaFindByIdService disciplinaFindByIdService;

    @Autowired
    private DisciplinaUpdateByIdService disciplinaUpdateByIdService;

    @Autowired
    private DisciplinaParcialUpdateByIdService disciplinaParcialUpdateByIdService;

    @Autowired
    private DisciplinaDeleteById disciplinaDeleteById;

    // Lista todas as disciplinas
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DisciplinaResponse> findAll(@RequestParam(required = false) boolean onlyActives) {
        return disciplinaFindAllService.execute(onlyActives);
    }

    // Cria uma nova disciplina
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public DisciplinaResponse create(@RequestBody DisciplinaRequest request) {
        return disciplinaCreateService.execute(request);
    }

    // Busca uma disciplina baseada no seu ID
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{id}")
    public DisciplinaResponse findById(@PathVariable String id) {
        return disciplinaFindByIdService.execute(id);
    }

    // Atualiza todos os dados de uma disciplina, baseada no seu ID
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public DisciplinaResponse updateById(@PathVariable String id, @RequestBody DisciplinaRequest request) {
        return disciplinaUpdateByIdService.execute(id, request);
    }

    // Exclusão lógica de uma disciplina
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable String id) {
        disciplinaDeleteById.execute(id);
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public DisciplinaResponse parcialUpdate(@PathVariable String id, @RequestBody DisciplinaRequest request) {
        return disciplinaParcialUpdateByIdService.execute(id, request);
    }
}
