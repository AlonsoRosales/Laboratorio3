package com.example.l3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Lista implements Serializable {
    List<Object> listaMascotas = new ArrayList<>();

    public List<Object> getListaMascotas() {
        return listaMascotas;
    }

    public void setListaMascotas(List<Object> listaMascotas) {
        this.listaMascotas = listaMascotas;
    }
}
