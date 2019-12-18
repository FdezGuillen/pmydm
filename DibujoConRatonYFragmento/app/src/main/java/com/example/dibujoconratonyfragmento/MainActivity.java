package com.example.dibujoconratonyfragmento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public View mFrg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFrg=(View)findViewById(R.id.miFrg);
        mFrg.setVisibility(View.VISIBLE);

    }
}
