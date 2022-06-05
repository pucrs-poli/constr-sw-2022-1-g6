package com.grupo6.grupo6.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Disciplina {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    private String id;

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

    @Column
    private Boolean ativa = true;
}
