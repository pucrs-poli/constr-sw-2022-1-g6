package com.grupo6.grupo6.controller;

import com.grupo6.grupo6.controller.request.CurriculoRequest;
import com.grupo6.grupo6.controller.request.DisciplinaRequest;
import com.grupo6.grupo6.controller.response.DisciplinaResponse;
import com.grupo6.grupo6.service.disciplina.DisciplinaCreateService;
import com.grupo6.grupo6.service.disciplina.DisciplinaFindAllService;
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

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DisciplinaResponse> findAll() {
        return disciplinaFindAllService.execute();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public DisciplinaResponse create(@RequestBody DisciplinaRequest request) {
        return disciplinaCreateService.execute(request);
    }
}
