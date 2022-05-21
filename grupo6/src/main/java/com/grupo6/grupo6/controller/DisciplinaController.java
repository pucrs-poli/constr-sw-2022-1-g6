package com.grupo6.grupo6.controller;

import com.grupo6.grupo6.controller.request.DisciplinaRequest;
import com.grupo6.grupo6.controller.response.DisciplinaResponse;
import com.grupo6.grupo6.service.disciplina.CreateService;
import com.grupo6.grupo6.service.disciplina.FindAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("disciplinas")
public class DisciplinaController {
    @Autowired
    private FindAllService findAllService;

    @Autowired
    private CreateService createService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DisciplinaResponse> findAll() {
        return findAllService.execute();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public DisciplinaResponse create(@RequestBody DisciplinaRequest request) {
        return createService.execute(request);
    }
}
