package com.example.ejrecopilatorio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ImageViewCompat;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Spinner spinnerZona;
    private Destino[] destinos = new Destino[]{
            new Destino("Zona A", "Asia y Oceanía", 30f, R.drawable.asia_y_oceania),
            new Destino("Zona B", "América y África", 20f, R.drawable.america_y_africa),
            new Destino("Zona C", "Europa", 10f, R.drawable.europa)
    };
    private Destino destinoSeleccionado;
    private boolean urgenteSeleccionado;
    private String tarifaSeleccionada;
    private String complementosSeleccionados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerZona = (Spinner)findViewById(R.id.spinnerZona);
        AdaptadorDestinos adaptador = new AdaptadorDestinos(this);
        spinnerZona.setAdapter(adaptador);

        final ImageView imagenSeleccionada = (ImageView)findViewById(R.id.imageZona);

        spinnerZona.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                imagenSeleccionada.setImageResource(destinos[position].getImagen());
                destinoSeleccionado = destinos[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });


        final EditText editPeso = (EditText)findViewById(R.id.editPeso);
        final RadioGroup radioGroup = (RadioGroup)findViewById(R.id.grupoTarifa);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(group.getCheckedRadioButtonId()==R.id.radioUrgente) {
                    urgenteSeleccionado = true;
                    tarifaSeleccionada = "Urgente";
                }else if(group.getCheckedRadioButtonId()==R.id.radioNormal){
                    urgenteSeleccionado = false;
                    tarifaSeleccionada = "Normal";
                }else{
                    urgenteSeleccionado = false;
                    tarifaSeleccionada = "Normal";
                }
            }
        });

        final CheckBox checkCaja = (CheckBox)findViewById(R.id.checkCaja);
        final CheckBox checkTarjeta = (CheckBox)findViewById(R.id.checkTarjeta);

        final Button botonCalcular = (Button) findViewById(R.id.buttonCalcular);
        //final TextView elSaludo = (TextView) findViewById(R.id.miLbl);


        botonCalcular.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){
                float precioTotal = destinoSeleccionado.calcularPrecioTotal(Float.parseFloat(editPeso.getText().toString()), urgenteSeleccionado);

                if (checkCaja.isChecked() && checkTarjeta.isChecked()) {
                    complementosSeleccionados = "Con caja regalo y tarjeta dedicatoria";
                }else if (!checkCaja.isChecked() && !checkTarjeta.isChecked()){
                    complementosSeleccionados = "Sin complementos";
                }else {
                    if (checkCaja.isChecked())
                        complementosSeleccionados = "Con caja regalo";
                    if( checkTarjeta.isChecked())
                        complementosSeleccionados = "Con tarjeta dedicatoria";
                }
                Intent miIntent= new Intent(MainActivity.this, PantallaResultado.class);
                Bundle miBundle=new Bundle();
                miBundle.putSerializable("CLAVEdest", destinoSeleccionado);
                miBundle.putFloat("PRECIOtotal", precioTotal);
                miBundle.putFloat("PESO",Float.parseFloat(editPeso.getText().toString()));
                miBundle.putString("COMP", complementosSeleccionados);
                miBundle.putString("TARIFA", tarifaSeleccionada);
                miIntent.putExtras(miBundle);
                startActivity(miIntent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menuprincipal, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.MnuOpc1:
                Toast.makeText(this,"¡Ya estás en esa actividad!", Toast.LENGTH_LONG).show();
                return true;
            case R.id.MnuOpc2:
                Intent miIntent2= new Intent(MainActivity.this, Dibujo.class);
                startActivity(miIntent2);
                return true;
            case R.id.MnuOpc3:
                Intent miIntent3= new Intent(MainActivity.this, AcercaDe.class);
                startActivity(miIntent3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }


    class AdaptadorDestinos extends ArrayAdapter {

        Activity context;

        AdaptadorDestinos(Activity context){
            super(context, R.layout.listazonas, destinos);
            this.context = context;
        }

        public View getDropDownView(int position, View convertView, ViewGroup parent){
            View vistaDesplegada = getView(position,convertView,parent);
            return vistaDesplegada;
        }

        public View getView(int i, View convertView, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listazonas, null);

            TextView labelZona = (TextView) item.findViewById(R.id.zona);
            labelZona.setText(destinos[i].getZona());

            TextView labelContinente = (TextView) item.findViewById(R.id.continente);
            labelContinente.setText(destinos[i].getContinente());

            TextView labelPrecio = (TextView) item.findViewById(R.id.precio);
            labelPrecio.setText(String.valueOf(destinos[i].getPrecio()) + "€");

            ImageView imagen = (ImageView) item.findViewById(R.id.imagenZona);
            imagen.setImageResource(destinos[i].getImagen());

            return (item);
        }
    }
}