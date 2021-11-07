package com.example.makhrijal_hurf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LearningActivity extends AppCompatActivity implements View.OnClickListener{
    Button halqiyahButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning);
        halqiyahButton=findViewById(R.id.halqiyah);
        halqiyahButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.halqiyah)
        {
            Intent intent =new Intent(this,HalqiyahActivity.class);
            startActivity(intent);
        }
    }
}