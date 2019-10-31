package com.example.listadoble;

import java.io.Serializable;
import java.util.ArrayList;

public class Autor implements Serializable {

    private String nombre;
    private String[] obras;

    public Autor(String nombre, String[] obras){
        this.nombre = nombre;
        this.obras = obras;
    }

    public String getNombre (){
        return nombre;
    }
    public String[] getObras(){
        return obras;
    }


    public void setNombre(String nuevoNom){
        nombre=nuevoNom;
    }
    public void setObras(String[] obras){
        this.obras = obras;
    }

}
