package com.example.fragmentosdinamicos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    // num Fragment
    int mStackPosition = 1;
    public int imagenes[] = {
            R.drawable.coche, R.drawable.bici, R.drawable.monociclo, R.drawable.gato, R.drawable.perro, R.drawable.hamster};

    Random r = new Random();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Botón de añadir fragments
        Button button = (Button)findViewById(R.id.newFragment);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                addFragment();
            }
        });

        if (savedInstanceState == null) {
            // añdir el primer fragment
            Fragment newFragment = SimpleFragment.newInstance(mStackPosition, imagenes[r.nextInt(imagenes.length)]);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.fragmentShow, newFragment).commit();
        } else {
            mStackPosition = savedInstanceState.getInt("position");
        }
    }

    void addFragment() {
        mStackPosition++;
        // Instanciamos nuevo Fragment

        Fragment newFragment = SimpleFragment.newInstance(mStackPosition, imagenes[r.nextInt(imagenes.length)]);
        // Se aÃ±ade el Fragment a la actividad
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentShow, newFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        // añadimos la transación a la pila
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("position", mStackPosition);
    }

}