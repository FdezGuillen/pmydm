package com.example.ejerarea;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Spinner miSpinner;
    private String[] formas = new String[]{
            "Círculo",
            "Rectángulo",
            "Triángulo"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        miSpinner = (Spinner)findViewById(R.id.spFormas);

        ArrayAdapter<String> miAdaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, formas);
        miSpinner.setAdapter(miAdaptador);



        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                RelativeLayout contenedor = (RelativeLayout) findViewById(R.id.RelativeLayout_contenedor);

                LayoutInflater inflater = this.LayoutInflater();

                View laViewInflada = inflater.inflate(R.layout.circulo_layout, contenedor, true);

                String mensaje = "";
                mensaje = "Item clicked => " + formas[position];
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
