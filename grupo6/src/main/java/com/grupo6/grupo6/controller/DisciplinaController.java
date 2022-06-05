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
    private DisciplinaDeleteById disciplinaDeleteById;

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

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{id}")
    public DisciplinaResponse findById(@PathVariable String id) {
        return disciplinaFindByIdService.execute(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public DisciplinaResponse updateById(@PathVariable String id, @RequestBody DisciplinaRequest request) {
        return disciplinaUpdateByIdService.execute(id, request);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        disciplinaDeleteById.execute(id);
    }
}
