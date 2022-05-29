package com.grupo6.grupo6.controller;

import com.grupo6.grupo6.controller.request.CursoRequest;
import com.grupo6.grupo6.controller.response.CursoResponse;
import com.grupo6.grupo6.service.curso.CreateService;
import com.grupo6.grupo6.service.curso.FindAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cursos")
public class CursoController {
    @Autowired
    private FindAllService findAllService;

    @Autowired
    private CreateService createService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CursoResponse> findAll() {
        return findAllService.execute();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public CursoResponse create(@RequestBody CursoRequest request) {
        return createService.execute(request);
    }
}
