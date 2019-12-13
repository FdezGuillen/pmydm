package com.example.examen1evcorregido;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static int imgDigits[] = {R.id.img_11, R.id.img_12, R.id.img_13};
    int tiposMedio[] = {R.drawable.patinete, R.drawable.bicis, R.drawable.coches};
    ImageView imagenes[];
    TextView textoElegido;
    ImageView imgElegida;
    Button miBoton;
    int op=0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoElegido = (TextView) findViewById(R.id.txtResul);
        imgElegida = (ImageView) findViewById(R.id.imgResul);

        imagenes = new ImageView[3];

        for (int i = 0; i < 3; i++){
            imagenes[i] = (ImageView) findViewById(imgDigits[i]);
        }

        for (int i=0; i<3; i++){
            imagenes[i].setOnClickListener(new MiEleccion());
        }

        miBoton = (Button) findViewById(R.id.btn);
        miBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miIntent = new Intent(MainActivity.this, Pantalla2.class);
                Bundle miBundle = new Bundle();
                miBundle.putInt("opcion", op);
                miIntent.putExtras(miBundle);
                startActivity(miIntent);
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

    class MiEleccion implements View.OnClickListener{
        @Override
        public void onClick(View v){
            ImageView iv = (ImageView) v;
            String opTxt="ALQUILER DE ";
            switch(iv.getId()){
                case R.id.img_11:
                    op=1;
                    opTxt+="PATINETES ELECTRICOS";
                    break;
                case R.id.img_12:
                    op=2;
                    opTxt+="BICICLETAS";
                    break;
                case R.id.img_13:
                    op=3;
                    opTxt+="COCHES";
                    break;
            }

            imgElegida.setImageDrawable(iv.getDrawable());
            textoElegido.setText(opTxt);
        }
    }
}
