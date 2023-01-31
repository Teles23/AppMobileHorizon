package com.example.apphorizon.model;

import java.io.Serializable;

public class Tarefa implements Serializable {
    private Long id;
    private String nomePaciente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }
}
