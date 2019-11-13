package com.example.ejrecopilatorio;


import java.io.Serializable;

public class Destino implements Serializable {

    private String zona;
    private String continente;
    private float precio;
    private int imagen;

    Destino(String zona, String continente, float precio, int imagen){
        this.zona = zona;
        this.continente = continente;
        this.precio = precio;
        this.imagen = imagen;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
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

    public float calcularPrecioTotal(float peso, boolean urgente){
        float precioTotal = precio;

        if (peso <= 5f)
            precioTotal++;
        else if (peso >= 6f && peso <=10f)
            precioTotal+=1.5f;
        else if (peso > 10.0f)
            precioTotal += 2f;

        if (urgente)
            precioTotal = precioTotal + (precioTotal*0.3f);

        return precioTotal;
    }

    @Override
    public String toString() {
        return "Destino{" +
                "zona='" + zona + '\'' +
                ", continente='" + continente + '\'' +
                ", precio=" + precio +
                ", imagen=" + imagen +
                '}';
    }
}