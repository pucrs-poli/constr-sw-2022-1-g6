package com.grupo6.grupo6.controller.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DisciplinaResponse {
    private String id;

    private String codigo;

    private Integer creditos;

    private String nome;

    private String objetivo;

    private String ementa;

    private Integer nivel;
}
