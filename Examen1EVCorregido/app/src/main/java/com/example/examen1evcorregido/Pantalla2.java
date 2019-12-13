package com.example.examen1evcorregido;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
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

import java.util.List;

public class Pantalla2 extends AppCompatActivity {

    public Spinner spinnerMedios;

    private MedioTransporte[][] mediosTransporte = new MedioTransporte[][]{
            {
                    new MedioTransporte("skate", "Roxi", 12, R.drawable.skate),
                    new MedioTransporte("patinete", "Roxi", 15, R.drawable.patinete),
                    new MedioTransporte("monociclo", "Oneil", 18, R.drawable.monociclo1),},
            {
                    new MedioTransporte("Paseo", "Orbea", 15, R.drawable.bici1),
                    new MedioTransporte("Ciudad", "Cube", 20, R.drawable.bici2),
                    new MedioTransporte("Montaña", "Bike", 25, R.drawable.bici3)},
            {
                    new MedioTransporte("Megane", "Renault", 60, R.drawable.megan1),
                    new MedioTransporte("Leon", "Seat", 70, R.drawable.leon3),
                    new MedioTransporte("Fiesta", "Ford", 75, R.drawable.fiesta2)}

    };
    private MedioTransporte[] medios;

    private boolean seguroCompleto;
    private String seguroSeleccionado;

    private MedioTransporte medioSeleccionado;

    private Factura factura;
    private float precioTotal=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        spinnerMedios = (Spinner)findViewById(R.id.spinnerMedio);
        int op = getIntent().getIntExtra("opcion", 0);
        medios = mediosTransporte[op-1];
        AdaptadorMedios adaptador = new AdaptadorMedios(this, R.id.spinnerMedio, medios);
        spinnerMedios.setAdapter(adaptador);

        spinnerMedios.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                medioSeleccionado = medios[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        final EditText editDias = (EditText)findViewById(R.id.editDias);

        final RadioGroup radioGroup = (RadioGroup)findViewById(R.id.grupoSeguro);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(group.getCheckedRadioButtonId()==R.id.radioCompleto) {
                    seguroCompleto = true;
                    seguroSeleccionado = "Seguro COMPLETO";
                }else if(group.getCheckedRadioButtonId()==R.id.radioSin){
                    seguroCompleto = false;
                    seguroSeleccionado = "Sin seguro";
                }else{
                    seguroCompleto = false;
                    seguroSeleccionado = "Sin seguro";
                }
            }
        });

        final CheckBox checkCasco = (CheckBox)findViewById(R.id.checkCasco);
        final CheckBox checkGps = (CheckBox)findViewById(R.id.checkGPS);
        final CheckBox checkExtra = (CheckBox)findViewById(R.id.checkExtra);

        final TextView textPrecio = (TextView)findViewById(R.id.labelPrecioTotal);
        Button btnCalcular = (Button)findViewById(R.id.buttonCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){
                float extras = 0;
                if (checkCasco.isChecked())
                    extras += 50;
                if (checkExtra.isChecked())
                    extras +=50;
                if (checkGps.isChecked())
                    extras += 50;

                factura = new Factura(medioSeleccionado,Integer.parseInt(editDias.getText().toString()),extras,seguroCompleto);
                precioTotal = factura.calcularTotal();
                if (precioTotal<=0)
                    Toast.makeText(getApplicationContext(),"Por favor, rellena el formulario", Toast.LENGTH_LONG).show();
                else
                    textPrecio.setText(precioTotal + "€");
            }
        });

        Button btnFactura = (Button) findViewById(R.id.buttonFactura);
        btnFactura.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){
                if (precioTotal<=0){
                    Toast.makeText(getApplicationContext(),"Primero calcula el precio", Toast.LENGTH_LONG).show();
                }else{
                    Intent miIntent= new Intent(Pantalla2.this, PantallaFactura.class);
                    Bundle miBundle=new Bundle();
                    miBundle.putSerializable("CLAVEfact", factura);
                    miIntent.putExtras(miBundle);
                    startActivity(miIntent);
                }
            }
        });


    }

    class AdaptadorMedios extends ArrayAdapter <MedioTransporte>{
        class Holder{
            TextView tvBrand;
            TextView tvModel;
            TextView tvPrice;
            ImageView ivImage;
        }
        private MedioTransporte[] transports;

        AdaptadorMedios(@NonNull Context context, int resource, MedioTransporte[] transports){
            super(context, resource, transports);
            this.transports = transports;
        }

        @NonNull
        @Override
        public View getView(int i, View convertView, @NonNull ViewGroup parent){
            View v = convertView;
            Holder h;
            if(v == null){
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listamedios, parent, false);
                h = new Holder();
                h.tvBrand = v.findViewById(R.id.marca);
                h.tvModel = v.findViewById(R.id.modelo);
                h.tvPrice = v.findViewById(R.id.precio);
                h.ivImage = v.findViewById(R.id.imagen);
                v.setTag(h);
            }else {
                h = (Holder) v.getTag();
            }
                MedioTransporte vehicle = transports[i];
                h.tvBrand.setText(vehicle.getMarca());
                h.tvModel.setText(vehicle.getModelo());
                h.tvPrice.setText(Float.toString(vehicle.getPrecio()));
                h.ivImage.setImageResource(vehicle.getImagen());
                return v;

        }

        public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
            View vistaDesplegada = getView(position,convertView,parent);
            return vistaDesplegada;
        }
    }
}
