package com.example.examen_1evaluacion_anaguillenfernandez;

import java.io.Serializable;

public class MedioTransporte implements Serializable {

    private String modelo;
    private String marca;
    private float precio;
    private int imagen;

    public MedioTransporte(String modelo, String marca, float precio, int imagen) {
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
        this.imagen = imagen;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
