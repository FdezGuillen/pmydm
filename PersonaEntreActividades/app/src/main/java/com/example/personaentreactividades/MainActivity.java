package com.example.personaentreactividades;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static int COD_RESPUESTA=0;
    //TextView elSaludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText nombre = (EditText) findViewById(R.id.campoNombre);
        final EditText apellidos = (EditText) findViewById(R.id.campoApellido);
        final EditText edad = (EditText) findViewById(R.id.campoEdad);

        final Button miBoton = (Button) findViewById(R.id.miBtn);
        //final TextView elSaludo = (TextView) findViewById(R.id.miLbl);


        miBoton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){

                Persona persona = new Persona(
                        nombre.getText().toString(),
                        apellidos.getText().toString(),
                        Integer.parseInt(edad.getText().toString()),
                        R.drawable.foto
                );

                showToast(persona.toString());

                Intent miIntent= new Intent(MainActivity.this, Pantalla2.class);
                Bundle miBundle=new Bundle();
                miBundle.putSerializable("CLAVEper", persona);
                miIntent.putExtras(miBundle);
                startActivity(miIntent);
            }
        });
    }

    protected void showToast(CharSequence text) {
        Context context = getApplicationContext();
        //CharSequence text = getResources().getString(R.string.noNameMsg);
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
