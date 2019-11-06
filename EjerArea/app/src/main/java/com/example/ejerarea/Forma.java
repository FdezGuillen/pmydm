package com.example.ejerarea;

import android.graphics.drawable.ShapeDrawable;

import java.io.Serializable;

public class Forma implements Serializable {

    private String nombre;
    private ShapeDrawable dibujo;

    public Forma(String nombre, ShapeDrawable dibujo){
        this.nombre = nombre;
        this.dibujo = dibujo;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}
