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

    //Al comenzar y dibujar por primera vez la pantalla del juego
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh){
        super.onSizeChanged(w,h,oldw,oldh);

        //Dibujamos los coches en posiciones aleatorias
        for (Grafico coche: Coches){
            do{
                coche.setPosX(Math.random()*(w-coche.getAncho()));
                coche.setPosY(Math.random()*(h-coche.getAlto()));
            }while(coche.distancia(bici) < (w+h)/5);
        }
        bici.setPosX((w-bici.getAncho())/2);
        bici.setPosY((h-bici.getAlto())/2);

        hiloJuego = new HiloJuego();
        hiloJuego.start();
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        //Dibujamos cada uno de los coches
        for(Grafico coche: Coches){
            coche.dibujaGrafico(canvas);
        }
        bici.dibujaGrafico(canvas);
    }

    protected synchronized void actualizaMovimiento() {
        long ahora = System.currentTimeMillis();
        // No hacemos nada si el período de proceso no se ha cumplido.
        if (ultimoProceso + PERIODO_PROCESO > ahora) {
            return;
        }
        // Para una ejecución en tiempo real calculamos retardo
        double retardo = (ahora - ultimoProceso) / PERIODO_PROCESO;

        // Actualizamos la posición de la bici
        bici.setAngulo((int) (bici.getAngulo() + giroBici * retardo));
        double nIncX = bici.getIncX() + aceleracionBici
                * Math.cos(Math.toRadians(bici.getAngulo())) * retardo;
        double nIncY = bici.getIncY() + aceleracionBici
                * Math.sin(Math.toRadians(bici.getAngulo())) * retardo;
        if (Grafico.distanciaE(0, 0, nIncX, nIncY) <= Grafico.getMaxVelocidad()) {
            bici.setIncX(nIncX);
            bici.setIncY(nIncY);
        }
        bici.incrementaPos();

        //Movemos los coches
        for (Grafico coche : Coches) {
            coche.incrementaPos();
        }
        ultimoProceso = ahora;
    }

    private class HiloJuego extends Thread {
        @Override
        public void run() {
            while (true) {
                actualizaMovimiento();
            }
        }
    }

}


