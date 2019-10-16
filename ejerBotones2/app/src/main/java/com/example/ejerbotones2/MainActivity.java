package com.example.ejerbotones2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView) findViewById(R.id.textView);

        final ImageButton rojoButton = (ImageButton) findViewById(R.id.rojoButton);
        rojoButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                textView.setBackgroundColor(Color.RED);
            }
        });

        final ImageButton blueButton = (ImageButton) findViewById(R.id.blueButton);
        blueButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                textView.setBackgroundColor(Color.BLUE);
            }
        });
    }

}
