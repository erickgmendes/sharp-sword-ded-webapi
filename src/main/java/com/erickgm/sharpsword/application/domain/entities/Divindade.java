package com.erickgm.sharpsword.application.domain.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "divindade")
public class Divindade implements Serializable {

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Tendencia getTendencia() {
        return tendencia;
    }

    public void setTendencia(Tendencia tendencia) {
        this.tendencia = tendencia;
    }

    public String getDominios() {
        return dominios;
    }

    public void setDominios(String dominios) {
        this.dominios = dominios;
    }

    public String getAdoradores_tipicos() {
        return adoradores_tipicos;
    }

    public void setAdoradores_tipicos(String adoradores_tipicos) {
        this.adoradores_tipicos = adoradores_tipicos;
    }

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String nome;
    private String titulo;
    private Tendencia tendencia;
    private String dominios;
    private String adoradores_tipicos;
}