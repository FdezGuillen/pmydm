package com.example.ejerradiocolores;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView)findViewById(R.id.textView);
        final RadioGroup rg = (RadioGroup)findViewById(R.id.gruporb);


        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                int color = 0;

                if( group.getCheckedRadioButtonId()==R.id.radioRojo)
                    color = Color.RED;
                else if( group.getCheckedRadioButtonId()==R.id.radioVerde)
                    color = Color.GREEN;
                else if( group.getCheckedRadioButtonId()==R.id.radioAzul)
                    color = Color.BLUE;

                textView.setBackgroundColor(color);


            }
        });


    }
}
