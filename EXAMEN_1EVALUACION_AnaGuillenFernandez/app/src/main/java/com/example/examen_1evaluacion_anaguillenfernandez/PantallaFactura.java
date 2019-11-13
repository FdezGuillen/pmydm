package com.example.examen_1evaluacion_anaguillenfernandez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PantallaFactura extends AppCompatActivity {

    Factura factura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_factura);


        factura = (Factura)getIntent().getSerializableExtra("CLAVEfact");

        ImageView imagen = (ImageView)findViewById(R.id.imagen);
        imagen.setImageResource(factura.getMedio().getImagen());

        TextView texto = (TextView)findViewById(R.id.textResultado);
        String textoAMostrar = "Modelo: " + factura.getMedio().getModelo() + "\n"+
                "Precio por días: " + factura.getMedio().getPrecio() + "€\n"+
                "Extras: " + factura.getExtras() + "€\n"+
                "Días: " + factura.getDias()+"\n";

        if (factura.getSeguro())
            textoAMostrar += "Seguro: Con Seguro COMPLETO\n";
        else
            textoAMostrar += "Seguro: Sin Seguro\n";
        texto.setText(textoAMostrar);

        TextView textTotal = (TextView)findViewById(R.id.textTotal);
        textTotal.setText("Coste Total: " + factura.calcularTotal() + "€");
    }
}
