package com.example.bdorganizada;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
public class MainActivity extends AppCompatActivity {
    public DatabaseHelper cliBDh = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cliBDh = new DatabaseHelper(this);
        cliBDh.open(); //Abrimos la base de datos en modo escritura
        //En caso de abrir de forma correcta la base de datos
        if (cliBDh != null) {
            // Introducimos 3 clientes de ejemplo
            for (int cont = 1; cont <= 3; cont++) {
                //Creamos los datos
                int codigo = cont;
                String nombre = "cli" + cont;
                String telefono = cont + "XXXXXXX";
                //Introducimos los datos en la tabla Clientes
                cliBDh.insertItem(codigo, nombre, telefono);
            }
        }
        cliBDh.close();
    }
}