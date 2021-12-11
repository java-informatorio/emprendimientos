package com.informatorio.emprendimientos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class OperacionEmprendimiento {

    @NotEmpty(message = "El nombre no puede ser vacio")
    private String nombre;

    @NotEmpty(message = "El descripcion no puede ser vacio")
    private String descripcion;

    @NotNull
    @Positive
    @JsonProperty(value = "id_usuario")
    private Long idUsuario;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
