package com.example.examen_1evaluacion_anaguillenfernandez;

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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Pantalla2 extends AppCompatActivity {

    public Spinner spinnerMedios;
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
        medios = (MedioTransporte[])getIntent().getSerializableExtra("CLAVEmedio");
        AdaptadorMedios adaptador = new AdaptadorMedios(this);
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

    class AdaptadorMedios extends ArrayAdapter {

        Activity context;

        AdaptadorMedios(Activity context){
            super(context, R.layout.listamedios, medios);
            this.context = context;
        }

        public View getDropDownView(int position, View convertView, ViewGroup parent){
            View vistaDesplegada = getView(position,convertView,parent);
            return vistaDesplegada;
        }

        public View getView(int i, View convertView, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listamedios, null);

            TextView labelModelo = (TextView) item.findViewById(R.id.modelo);
            labelModelo.setText(medios[i].getModelo());

            TextView labelMarca = (TextView) item.findViewById(R.id.marca);
            labelMarca.setText(medios[i].getMarca());

            TextView labelPrecio = (TextView) item.findViewById(R.id.precio);
            labelPrecio.setText(medios[i].getPrecio() + "€");

            ImageView imagen = (ImageView) item.findViewById(R.id.imagen);
            imagen.setImageResource(medios[i].getImagen());

            return (item);
        }
    }
}
