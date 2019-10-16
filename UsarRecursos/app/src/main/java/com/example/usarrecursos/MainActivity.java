package com.example.usarrecursos;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    MediaPlayer miMusica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miMusica = MediaPlayer.create(getApplicationContext(), R.raw.desigual);
        final ToggleButton btnBoton2 = (ToggleButton)findViewById(R.id.toggleButton);
        final Button boton = (Button) findViewById(R.id.button);

        final TextView texto = (TextView) findViewById(R.id.textView);
        final TextView texto2 = (TextView) findViewById(R.id.textView2);

        final ImageView imagen = (ImageView) findViewById(R.id.imageView);


        btnBoton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnBoton2.isChecked()) {
                    miMusica.start();
                    texto.setText("Adivina la canción");

                }else {
                    miMusica.stop();
                    texto.setText("Música");

                }
            }
        });

        boton.setOnClickListener(new View.OnClickListener() {
            boolean respuesta = false;

            @Override
            public void onClick(View v) {
                respuesta = !respuesta;

                if (respuesta){
                    imagen.setImageResource(R.drawable.marcadesigual);
                    texto2.setText("CANCIÓN: Desigual");
                    boton.setText("Ocultar respuesta");

                }else{
                    imagen.setImageResource(R.drawable.degradado);
                    texto2.setText("Adivina la canción");
                    boton.setText("Mostrar respuesta");

                }
            }
        });
    }
}
