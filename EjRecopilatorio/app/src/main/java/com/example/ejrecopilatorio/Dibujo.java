package com.example.ejrecopilatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Dibujo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MiDibujo(this));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menuprincipal, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.MnuOpc1:
                Intent miIntent1= new Intent(Dibujo.this, MainActivity.class);
                startActivity(miIntent1);
                return true;
            case R.id.MnuOpc2:
                Toast.makeText(this,"¡Ya estás en esa actividad!", Toast.LENGTH_LONG).show();
                return true;
            case R.id.MnuOpc3:
                Intent miIntent3= new Intent(Dibujo.this, AcercaDe.class);
                startActivity(miIntent3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

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
