package com.example.makhrijal_hurf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LearningActivity extends AppCompatActivity implements View.OnClickListener{
    Button halqiyahButton,lahatiyahButton,haafiyahButton;
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
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }
}