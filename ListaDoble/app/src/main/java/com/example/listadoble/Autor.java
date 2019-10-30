package com.example.listadoble;

import java.util.ArrayList;

public class Autor {

    private String nombre;
    private ArrayList<String> obras = new ArrayList<String>();

    public Autor(String nombre, ArrayList<String> obras){
        this.nombre = nombre;
        this.obras = obras;
    }

    public String getNombre (){
        return nombre;
    }
    public ArrayList<String> getObras(){
        return obras;
    }


    public void setNombre(String nuevoNom){
        nombre=nuevoNom;
    }
    public void setObras(ArrayList<String> obras){
        this.obras = obras;
    }

    public void addObra(String obra){
        obras.add(obra);
    }
}
