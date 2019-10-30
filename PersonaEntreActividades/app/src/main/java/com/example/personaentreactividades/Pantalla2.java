package com.example.personaentreactividades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Pantalla2 extends Activity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);



        TextView miNom= (TextView) findViewById(R.id.nombreView);
        TextView miEd = (TextView) findViewById(R.id.edadView);
        ImageView mifoto =(ImageView)findViewById(R.id.fotoView);

        Persona persona =(Persona)getIntent().getSerializableExtra("CLAVEper");

        Toast.makeText(this,persona.toString(), Toast.LENGTH_LONG).show();

        miNom.setText(persona.getNombre() + " " + persona.getApellido());
        miEd.setText("EDAD: " + String.valueOf(persona.getEdad()));
        mifoto.setImageResource(persona.getFoto());

        final Button miBoton = (Button) findViewById(R.id.miBtn);

        miBoton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){
                Intent miIntent= new Intent(Pantalla2.this, MainActivity.class);
                startActivity(miIntent);
            }
        });
    }
}