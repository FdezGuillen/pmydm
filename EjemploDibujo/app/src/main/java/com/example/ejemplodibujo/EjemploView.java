package com.example.ejemplodibujo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class EjemploView extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MiDibujo(this));
    }

    class MiDibujo extends View{
        public MiDibujo(Context c){
            super(c);
        }

        protected void onDraw(Canvas lienzo){
            int ancho = getWidth();
            int alto = getHeight();
            int centroX = ancho/2;
            int centroY = alto/2;


            Paint pincel = new Paint();
            pincel.setColor(Color.MAGENTA);
            pincel.setStrokeWidth(10);
            pincel.setStyle(Paint.Style.STROKE);
            pincel.setTextSize(120);
            lienzo.drawCircle(centroX, centroY,110,pincel);
            lienzo.drawText("Círculo magenta",100,800,pincel);
        }
    }



}
