package com.example.examen_1evaluacion_anaguillenfernandez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /* LOGOS DE LA PRIMERA  PANTALLA */
    int tiposMedio[] = {R.drawable.patinete, R.drawable.bicis, R.drawable.coches};

    /* Contenido de los spinner segun los medios elegidos */
    private MedioTransporte[] electricos = new MedioTransporte[]{
            new MedioTransporte("skate", "Roxi", 12, R.drawable.skate),
            new MedioTransporte("patinete", "Roxi", 15, R.drawable.patinete),
            new MedioTransporte("monociclo", "Oneil", 18, R.drawable.monociclo1)};

    private MedioTransporte[] bicis = new MedioTransporte[]{
            new MedioTransporte("Paseo", "Orbea", 15, R.drawable.bici1),
            new MedioTransporte("Ciudad", "Cube", 20, R.drawable.bici2),
            new MedioTransporte("Montaña", "Bike", 25, R.drawable.bici3)};

    private MedioTransporte[] coches = new MedioTransporte[]{
            new MedioTransporte("Megane", "Renault", 60, R.drawable.megan1),
            new MedioTransporte("Leon", "Seat", 70, R.drawable.leon3),
            new MedioTransporte("Fiesta", "Ford", 75, R.drawable.fiesta2)};

    private MedioTransporte[] medioSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imagenResul = (ImageView)findViewById(R.id.imgResul);

        ImageView imagenElectricos = (ImageView)findViewById(R.id.img_11);
        imagenElectricos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                medioSeleccionado = electricos;
                imagenResul.setImageResource(tiposMedio[0]);
            }
        });

        ImageView imagenBicis = (ImageView)findViewById(R.id.img_12);
        imagenBicis.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                medioSeleccionado = bicis;
                imagenResul.setImageResource(tiposMedio[1]);
            }
        });

        ImageView imagenCoches = (ImageView)findViewById(R.id.img_13);
        imagenCoches.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                medioSeleccionado = coches;
                imagenResul.setImageResource(tiposMedio[2]);
            }
        });

        Button btnContinuar = (Button)findViewById(R.id.btn);
        btnContinuar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){
                if (medioSeleccionado == null){
                    Toast.makeText(getApplicationContext(),"Primero elige un tipo de transporte", Toast.LENGTH_LONG).show();
                }else{
                    Intent miIntent= new Intent(MainActivity.this, Pantalla2.class);
                    Bundle miBundle=new Bundle();
                    miBundle.putSerializable("CLAVEmedio",medioSeleccionado);
                    miIntent.putExtras(miBundle);
                    startActivity(miIntent);
                }

            }
        });
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
                Intent miIntent1= new Intent(MainActivity.this, Dibujo.class);
                startActivity(miIntent1);
                return true;
            case R.id.MnuOpc2:
                Intent miIntent2= new Intent(MainActivity.this, Ayuda.class);
                startActivity(miIntent2);
                return true;
            case R.id.MnuOpc3:
                Intent miIntent3= new Intent(MainActivity.this, Copyright.class);
                startActivity(miIntent3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
