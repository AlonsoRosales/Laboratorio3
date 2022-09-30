package com.example.l3;

import java.io.Serializable;

public class Mascota implements Serializable {
    private String nombre = null;
    private String genero = null;
    private String nombreDuenho = null;
    private String DNI = null;
    private String descripcion = null;
    private String ruta;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNombreDuenho() {
        return nombreDuenho;
    }

    public void setNombreDuenho(String nombreDuenho) {
        this.nombreDuenho = nombreDuenho;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Mascota(String nombre, String genero, String nombreDuenho, String DNI, String descripcion) {
        this.nombre = nombre;
        this.genero = genero;
        this.nombreDuenho = nombreDuenho;
        this.DNI = DNI;
        this.descripcion = descripcion;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
}
