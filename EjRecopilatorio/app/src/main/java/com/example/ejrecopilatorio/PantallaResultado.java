package com.example.ejrecopilatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class PantallaResultado extends AppCompatActivity {

    Destino destino;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_resultado);

        destino = (Destino)getIntent().getSerializableExtra("CLAVEdest");
        float precioTotal = (float)getIntent().getFloatExtra("PRECIOtotal",0f);
        float peso = (float)getIntent().getFloatExtra("PESO",0f);
        String complementos = (String)getIntent().getStringExtra("COMP");
        String tarifa = (String)getIntent().getStringExtra("TARIFA");

        ImageView imagen = (ImageView)findViewById(R.id.imageZona);
        imagen.setImageResource(destino.getImagen());
        registerForContextMenu(imagen);

        TextView texto = (TextView)findViewById(R.id.textResultado);
        String textoAMostrar = destino.getZona() + " (" + destino.getContinente() + ")\n" +
                "Tarifa: " + tarifa + "\n" +
                "Peso: " + peso + "kg\n\n" +
                "Decoración: " + complementos + "\n" +
                "COSTE FINAL: " + precioTotal + "€";
        texto.setText(textoAMostrar);

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
                Intent miIntent1= new Intent(PantallaResultado.this, MainActivity.class);
                startActivity(miIntent1);
                return true;
            case R.id.MnuOpc2:
                Intent miIntent2= new Intent(PantallaResultado.this, Dibujo.class);
                startActivity(miIntent2);
                return true;
            case R.id.MnuOpc3:
                Intent miIntent3= new Intent(PantallaResultado.this, AcercaDe.class);
                startActivity(miIntent3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_ctx_etiqueta, menu);
    }

    public boolean onContextItemSelected(MenuItem itemMnuContex) {
        switch (itemMnuContex.getItemId()) {
            case R.id.CtxLblOpc1:
                Toast.makeText(this,destino.toString(), Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onContextItemSelected(itemMnuContex);
        }
    }
}
