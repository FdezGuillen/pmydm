package com.example.ejemlayout2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class tableLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_layout);

        final Button volverButton = (Button) findViewById(R.id.volverButton);

        volverButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){
                Intent miIntent= new Intent(tableLayout.this, MainActivity.class);
                startActivity(miIntent);
            }
        });
    }
}
