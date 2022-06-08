package com.grupo6.grupo6.controller.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CursoResponse {
    private String id;

    private String nome;

    private List<CurriculoResponse> curriculos;
}
