package com.example.makhrijal_hurf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LearningActivity extends AppCompatActivity implements View.OnClickListener{
    Button halqiyahButton,lahatiyahButton,haafiyahButton,tarfiyahButton,niteeyahButton,lisaveyehButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning);
        halqiyahButton=findViewById(R.id.halqiyah);
        halqiyahButton.setOnClickListener(this);
        lahatiyahButton=findViewById(R.id.lahatiyah);
        lahatiyahButton.setOnClickListener(this);
        haafiyahButton=findViewById(R.id.haafiyah);
        haafiyahButton.setOnClickListener(this);
        tarfiyahButton=findViewById(R.id.tarfiyah);
        tarfiyahButton.setOnClickListener(this);
        niteeyahButton=findViewById(R.id.niteeyah);
        niteeyahButton.setOnClickListener(this);
        lisaveyehButton=findViewById(R.id.lisaveyah);
        lisaveyehButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.halqiyah:
                intent = new Intent(this, HalqiyahActivity.class);
                startActivity(intent);
                break;

            case R.id.lahatiyah:
                intent = new Intent(this, LahatiyahActivity.class);
                startActivity(intent);
                break;
            case R.id.haafiyah:
                intent=new Intent(this,Shajariyah_HaafiyahActivity.class);
                startActivity(intent);
                break;
            case R.id.tarfiyah:
                intent = new Intent(this,TarfiyahActivity.class);
                startActivity(intent);
                break;
            case R.id.niteeyah:
                intent = new Intent(this,Nit_EeyahActivity.class);
                startActivity(intent);
                break;
            case R.id.lisaveyah:
                intent = new Intent(this,LisaveyahActivity.class);
                startActivity(intent);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }
}