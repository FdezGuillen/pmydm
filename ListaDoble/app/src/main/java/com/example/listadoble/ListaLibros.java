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
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class ListaLibros extends AppCompatActivity {

    public static Autor autor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_libros);

        TextView nombreAutor= (TextView) findViewById(R.id.nombreAutor);
        autor =(Autor)getIntent().getSerializableExtra("CLAVEautor");
        nombreAutor.setText("Obras de " + autor.getNombre());

        AdaptadorObras adaptador = new AdaptadorObras(this);

        ListView lview = (ListView) findViewById(R.id.lista);
        try {

            lview.setAdapter(adaptador);
            lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                public void onItemClick(AdapterView arg0, View arg1, int position, long id) {
                }
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        final Button miBoton = (Button) findViewById(R.id.miBtn);

        miBoton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){
                Intent miIntent= new Intent(ListaLibros.this, MainActivity.class);
                startActivity(miIntent);
            }
        });

    }

    class AdaptadorObras extends ArrayAdapter {

        Activity context;

        AdaptadorObras(Activity context){
            super(context, R.layout.listitem_obra, autor.getObras());
            this.context = context;
        }

        public View getView(int i, View convertView, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_obra, null);

            TextView labelNombre = (TextView) item.findViewById(R.id.nombreObra);
            labelNombre.setText(autor.getObras()[i]);
            return (item);
        }
    }
}
