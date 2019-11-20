package com.example.solobici;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Vector;

public class VistaJuego extends View {

    // COCHES
    private Vector<Grafico> Coches;
    private int numCoches = 5;
    private int numMotos = 3;

    // BICI
    private Grafico bici;
    private int giroBici; //incremento dirección de la bici
    private float aceleracionBici; //incremento velocidad de la bici
    private static final int PASO_GIRO_BICI = 5;
    private static final float PASO_ACELERACION_BICI = 0.5f;

    // HILO Y TIEMPO
    private HiloJuego hiloJuego; // hilo encargado de procesar el tiempo
    private static int PERIODO_PROCESO = 50; // miliseg que deben transcurrir para procesar cambios
    private long ultimoProceso = 0; // momento en el que se realiza el último proceso

    public VistaJuego(Context contexto, AttributeSet atributos){
        super(contexto, atributos);
        Drawable graficoBici, graficoCoche, graficoRueda;

        graficoCoche = contexto.getResources().getDrawable(R.drawable.coche);

        //Creamos vector y lo rellenamos con coches generados con datos aleatorios
        Coches = new Vector<Grafico>();
        for (int i=0; i<numCoches; i++){
            Grafico coche = new Grafico(this, graficoCoche);
            coche.setIncX(Math.random()*4-2);
            coche.setIncY(Math.random()*4-2);
            coche.setAngulo((int)(Math.random()*360));
            coche.setRotacion((int)(Math.random()*8-4));
            Coches.add(coche);
        }

        // BICI
        graficoBici = contexto.getResources().getDrawable(R.drawable.bici);
        bici = new Grafico(this, graficoBici);
    }

    //Al comenzar
}


