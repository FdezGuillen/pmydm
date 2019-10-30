package com.example.eventos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Context ctx=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ctx = this;

        Button btn1=(Button)this.findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(ctx,"Evento desde onClickListener", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void eventoToast(View v){
        Toast.makeText(ctx,"Evento desde UI", Toast.LENGTH_SHORT).show();
    }
    
}
