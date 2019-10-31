package com.example.listadoble;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static Autor[] autores = new Autor[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] librosCervantes = new String[2];
        librosCervantes[0] = "El Quijote";
        librosCervantes[1] = "Novelas ejemplares";

        String[] librosShakespeare = new String[4];
        librosShakespeare[0] = "Hamlet";
        librosShakespeare[1] = "Otelo";
        librosShakespeare[2] = "Romeo y Julieta";
        librosShakespeare[3] = "Macbeth";

        autores[0] = new Autor("Cervantes", librosCervantes);
        autores[1] = new Autor("Shakespeare", librosShakespeare);

        AdaptadorAutores adaptador = new AdaptadorAutores(this);

       ListView lview = (ListView) findViewById(R.id.listView);
        try {

            lview.setAdapter(adaptador);
            lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                public void onItemClick(AdapterView arg0, View arg1, int position, long id) {
                    Autor autor = autores[position];
                    Intent miIntent= new Intent(MainActivity.this, ListaLibros.class);
                    Bundle miBundle=new Bundle();
                    miBundle.putSerializable("CLAVEautor", autor);
                    miIntent.putExtras(miBundle);
                    startActivity(miIntent);
                }
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
        }catch(Exception e){
            System.out.println(e.getMessage());
        }


    }

    class AdaptadorAutores extends ArrayAdapter {

        Activity context;

        AdaptadorAutores(Activity context){
            super(context, R.layout.listitem_autor, autores);
            this.context = context;
        }

        public View getView(int i, View convertView, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_autor, null);

            TextView labelNombre = (TextView) item.findViewById(R.id.nombre);
            labelNombre.setText(autores[i].getNombre());

           /* ImageView imagen = (ImageView) item.findViewById(R.id.fotoPersona);
            imagen.setImageResource(personas[i].getFoto());*/

            return (item);
        }
    }
}
