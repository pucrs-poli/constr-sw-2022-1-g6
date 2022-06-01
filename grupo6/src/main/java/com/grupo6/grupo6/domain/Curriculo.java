package com.grupo6.grupo6.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Curriculo {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    private String id;

    @Column
    private String nome;

    @ManyToOne
    @JoinColumn(name="curso_id", nullable=false)
    private Curso curso;
}
