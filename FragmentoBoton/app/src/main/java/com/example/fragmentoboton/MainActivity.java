package com.example.fragmentoboton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public View mFrg;
    public CheckBox mChk;
    public Button btn;

    public int imagenes[] = {
        R.drawable.coche, R.drawable.bici, R.drawable.monociclo, R.drawable.gato, R.drawable.perro, R.drawable.hamster};
    int mStackPosition = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFrg=(View)findViewById(R.id.miFrg);
        /* RECUERDA: el fragmento se infla como una vista*/
        mChk=(CheckBox)findViewById(R.id.aparece);
        mChk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(mChk.isChecked())mFrg.setVisibility(View.VISIBLE);
                else mFrg.setVisibility(View.INVISIBLE);
            }
        });


        btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment();
            }
        });

        if (savedInstanceState == null){
            Fragment miFragment = MiFragment.newInstance(imagenes[0]);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.miFrg, miFragment);
            ft.commit();
        }else{
            mStackPosition = savedInstanceState.getInt("position");
        }

    }

    public void addFragment(){
        Fragment miFragment;
        Random r = new Random();
        miFragment = MiFragment.newInstance(imagenes[r.nextInt(imagenes.length)]);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.miFrg, miFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState){
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt("position", mStackPosition);
    }
}