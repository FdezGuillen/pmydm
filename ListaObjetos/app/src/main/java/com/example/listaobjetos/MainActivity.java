package com.example.listaobjetos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
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

public class MainActivity extends AppCompatActivity {

    private Persona[] personas = new Persona[]{
            new Persona("Juan", "Pérez", 46, R.drawable.juan),
            new Persona("Susana", "González", 20, R.drawable.susana),
            new Persona("Pepa", "Flores", 75, R.drawable.pepa)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AdaptadorPersonas adaptador = new AdaptadorPersonas(this);
        ListView lstOpciones = (ListView) findViewById(R.id.LstOpciones);

        try {
            lstOpciones.setAdapter(adaptador);


            lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                public void onItemClick(AdapterView arg0, View arg1, int position, long id) {
                    String mensaje = "Nombre: " + personas[position].getNombre()
                            + "Apellidos: " + personas[position].getApellido();

                    Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
                }

                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    class AdaptadorPersonas extends ArrayAdapter {

        Activity context;

        AdaptadorPersonas(Activity context){
            super(context, R.layout.listitem_persona, personas);
            this.context = context;
        }

        public View getView(int i, View convertView, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_persona, null);

            TextView labelNombre = (TextView) item.findViewById(R.id.nombrePersona);
            labelNombre.setText(personas[i].getNombre());

            TextView labelApellidos = (TextView) item.findViewById(R.id.apellidosPersona);
            labelApellidos.setText(personas[i].getApellido());

            TextView labelEdad = (TextView) item.findViewById(R.id.edadPersona);
            labelEdad.setText(String.valueOf(personas[i].getEdad()));

            ImageView imagen = (ImageView) item.findViewById(R.id.fotoPersona);
            imagen.setImageResource(personas[i].getFoto());

            return (item);
        }
    }
}


