package com.grupo6.grupo6.controller;

import com.grupo6.grupo6.controller.request.CurriculoRequest;
import com.grupo6.grupo6.controller.response.CurriculoResponse;
import com.grupo6.grupo6.service.curriculo.CreateService;
import com.grupo6.grupo6.service.curriculo.FindAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("curriculos")
public class CurriculoController {
    @Autowired
    private FindAllService findAllService;

    @Autowired
    private CreateService createService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CurriculoResponse> findAll() {
        return findAllService.execute();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public CurriculoResponse create(@RequestBody CurriculoRequest request) {
        return createService.execute(request);
    }
}
