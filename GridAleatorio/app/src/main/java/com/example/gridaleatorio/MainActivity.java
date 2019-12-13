package com.example.gridaleatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    GridLayout gridLayout;
    Integer[] imagenes = new Integer[]{R.drawable.bici1, R.drawable.bici2, R.drawable.bici3,
            R.drawable.fiesta2, R.drawable.leon3, R.drawable.megan1, R.drawable.monociclo1,
            R.drawable.monociclo2, R.drawable.skate};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridLayout = (GridLayout) findViewById(R.id.LayoutPrincipal);
        int cont = gridLayout.getChildCount();

        for (int i = 0; i < cont-1; i++) {

            ImageView imagen = (ImageView) gridLayout.getChildAt(i);

            if (imagen instanceof ImageView) {

                final int randomImg = RandomUtils.randomElement(imagenes);
                imagen.setImageResource(randomImg);

                imagen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ImageView ultimaImagen = (ImageView) gridLayout.getChildAt(gridLayout.getChildCount()-1);
                        ultimaImagen.setImageResource(randomImg);
                    }
                });

            }

        }
    }


}
