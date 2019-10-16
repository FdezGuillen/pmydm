package com.example.holamundo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Pantalla extends Activity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        final TextView otroSaludo= (TextView)findViewById(R.id.miMensaje);
        Bundle miBundleRecoger = getIntent().getExtras();
        otroSaludo.setText(miBundleRecoger.getString("TEXTO"));

        final Button miBoton = (Button) findViewById(R.id.miBtn);

        miBoton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){
                Intent miIntent= new Intent(Pantalla.this, MainActivity.class);
                startActivity(miIntent);
            }
        });
    }
}