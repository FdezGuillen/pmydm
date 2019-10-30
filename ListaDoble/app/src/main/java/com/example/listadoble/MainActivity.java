package com.example.listadoble;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static Autor[] autores = new Autor[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> librosCervantes = new ArrayList<String>();
        librosCervantes.add("El Quijote");
        librosCervantes.add("Novelas ejemplares");

        ArrayList<String> librosShakespeare = new ArrayList<String>();
        librosShakespeare.add("Hamlet");
        librosShakespeare.add("Otelo");
        librosShakespeare.add("Romeo y Julieta");

        autores[0] = new Autor("Cervantes", librosCervantes);
        autores[1] = new Autor("Shakespeare", librosShakespeare);

        AdaptadorAutores adaptador = new AdaptadorAutores(this);

       ListView lview = (ListView) findViewById(R.id.listView);
        try {
            lview.setAdapter(adaptador);


            lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                public void onItemClick(AdapterView arg0, View arg1, int position, long id) {
                    String mensaje = "Nombre: " + autores[position].getNombre();

                    Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
                }

                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
        }catch(Exception e){
            System.out.println(e.getMessage());
        }


        lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView arg0, View arg1, int position, long id) {
                String mensaje="";
                mensaje="Item clicked => " + semana[position];
                Toast.makeText(getApplicationContext(),mensaje, Toast.LENGTH_SHORT).show();

            }
        });

    }
}
