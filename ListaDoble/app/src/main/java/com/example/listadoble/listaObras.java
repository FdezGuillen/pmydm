package com.example.listadoble;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class listaObras extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_obras);


        TextView nombreAutor= (TextView) findViewById(R.id.nombreAutor);
        Autor autor =(Autor)getIntent().getSerializableExtra("CLAVEautor");
        nombreAutor.setText(autor.getNombre());


    }
}
