package com.example.figurasaleatorias;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class DrawShapes2 extends AppCompatActivity {

    TextView textCont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_shapes2);
        textCont = (TextView)findViewById(R.id.textCont);

        View vista = (View) findViewById(R.id.vistaFiguras);
        vista.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int numOval = ShapeDrawableView.getContOval();
                int numRect = ShapeDrawableView.getContRect();
                textCont.setText("Círculos: " + numOval + "\n"+
                        "Cuadrados: " + numRect + "\n");
                return false;
            }
        });
    }
}
