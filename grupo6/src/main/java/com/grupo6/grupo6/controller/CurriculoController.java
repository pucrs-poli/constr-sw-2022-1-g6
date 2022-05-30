package com.grupo6.grupo6.controller;

import com.grupo6.grupo6.controller.request.CurriculoRequest;
import com.grupo6.grupo6.controller.response.CurriculoResponse;
import com.grupo6.grupo6.service.curriculo.CurriculoCreateService;
import com.grupo6.grupo6.service.curriculo.CurriculoFindAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("curriculos")
public class CurriculoController {
    @Autowired
    private CurriculoFindAllService curriculoFindAllService;

    @Autowired
    private CurriculoCreateService curriculoCreateService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CurriculoResponse> findAll() {
        return curriculoFindAllService.execute();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public CurriculoResponse create(@RequestBody CurriculoRequest request) {
        return curriculoCreateService.execute(request);
    }
}
