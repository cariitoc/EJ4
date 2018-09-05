package com.example.estudiante.ej4;

import android.media.Image;

public class Contacto {

    private String nombre;
    private String telefono;
    //private string urlImage
    private String genero;


    public Contacto(String nombre, String telefono, String genero) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }


    public String getTelefono() {
        return telefono;
    }

    public String getGenero() {
        return genero;
    }


}
