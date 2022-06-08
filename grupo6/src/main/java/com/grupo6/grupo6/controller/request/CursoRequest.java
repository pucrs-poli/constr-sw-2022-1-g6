package com.grupo6.grupo6.controller.request;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CursoRequest {

    private String nome;

    private List<CurriculoRequest> curriculos = new ArrayList<>();
}
