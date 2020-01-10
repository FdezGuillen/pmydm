package com.example.spinnerfragmento;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public View mFrg;
    public Spinner miSpinner;
    private Persona[] personas = new Persona[]{
            new Persona("Harold", "Pérez", 46, R.drawable.harold),
            new Persona("Pepa", "Flores", 75, R.drawable.pepa)
    };
    int mStackPosition = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFrg=(View)findViewById(R.id.miFrg);
        miSpinner = (Spinner)findViewById(R.id.spPersona);
        AdaptadorPersonas miAdaptador = new AdaptadorPersonas(this);
        miSpinner.setAdapter(miAdaptador);




        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String mensaje = "";
                mensaje = "Item clicked => " + personas[position];
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
                addFragment();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        if (savedInstanceState == null){
            Fragment miFragment = MiFragment.newInstance(personas[0]);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.miFrg, miFragment);
            ft.commit();
        }else{
            mStackPosition = savedInstanceState.getInt("position");
        }

    }

    public void addFragment(){
        Fragment miFragment;
        Random r = new Random();
        miFragment = MiFragment.newInstance(personas[r.nextInt(personas.length)]);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.miFrg, miFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState){
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt("position", mStackPosition);
    }


    class AdaptadorPersonas extends ArrayAdapter {

        Activity context;

        AdaptadorPersonas(Activity context){
            super(context, R.layout.milista, personas);
            this.context = context;
        }

        public View getDropDownView(int position, View convertView, ViewGroup parent){
            View vistaDesplegada = getView(position,convertView,parent);
            return vistaDesplegada;
        }

        public View getView(int i, View convertView, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.milista, null);

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
