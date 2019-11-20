package com.example.solobici;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button BAcercaDe;
    private Button BJuego;
    private Button BSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView lblMensaje = (TextView) findViewById(R.id.Titulo);

        BJuego = (Button) findViewById(R.id.BotonJugar);
        BJuego.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                lanzarJuego();
            }
        });

        BAcercaDe = (Button) findViewById(R.id.BotonAcercaDe);
        BAcercaDe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                lanzarAcercaDe();
            }
        });

        BSalir = (Button) findViewById(R.id.BotonSalir);
        BSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salir();
            }
        });
    }

    public void lanzarJuego(){
        Intent intent = new Intent(this, Juego.class);
        startActivity(intent);
    }

    public void lanzarAcercaDe(){
        Intent intent = new Intent(this, AcercaDe.class);
        startActivity(intent);
    }

    public void salir(){
        finish();
    }


}
