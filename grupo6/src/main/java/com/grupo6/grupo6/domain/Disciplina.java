package com.grupo6.grupo6.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String codigo;

    @Column
    private Integer creditos;

    @Column
    private String nome;

    @Column
    private String objetivo;

    @Column
    private String ementa;

    @Column
    private Integer nivel;
}
