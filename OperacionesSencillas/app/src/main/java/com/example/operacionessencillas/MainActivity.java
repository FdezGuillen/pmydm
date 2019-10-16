package com.example.operacionessencillas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String operacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RadioGroup rg = (RadioGroup) findViewById(R.id.gruporb);

        rg.clearCheck();
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String textoOpcion="";
                if( group.getCheckedRadioButtonId()==R.id.radioSumar)
                    operacion = "sumar";
                else if( group.getCheckedRadioButtonId()==R.id.radioRestar)
                    operacion = "restar";
            }
        });

        Button buttonOperar = (Button) findViewById(R.id.buttonOperar);
        buttonOperar.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                final EditText num1 = (EditText) findViewById(R.id.num1);
                final EditText num2 = (EditText) findViewById(R.id.num2);

                final TextView resultado = (TextView) findViewById(R.id.resultado);

                int r = 0;

                if (operacion == "sumar")
                    r = Integer.parseInt(num1.getText().toString()) + Integer.parseInt(num2.getText().toString());
                else if (operacion == "restar")
                    r = Integer.parseInt(num1.getText().toString()) - Integer.parseInt(num2.getText().toString());

                resultado.setText("Resultado: " + r);

            }
        });

    }
}
