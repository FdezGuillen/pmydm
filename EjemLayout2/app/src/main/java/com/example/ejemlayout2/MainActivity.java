package com.example.ejemlayout2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickLinear(View v){
        Intent miIntent= new Intent(MainActivity.this, linearLayout.class);
        startActivity(miIntent);
    }

    public void onClickTable(View v){
        Intent miIntent= new Intent(MainActivity.this, tableLayout.class);
        startActivity(miIntent);
    }

    public void onClickRelative(View v){
        Intent miIntent= new Intent(MainActivity.this, relativeLayout.class);
        startActivity(miIntent);
    }

    public void onClickGrid(View v){
        Intent miIntent= new Intent(MainActivity.this, gridLayout.class);
        startActivity(miIntent);
    }

}
