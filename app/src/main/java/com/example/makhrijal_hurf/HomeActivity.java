package com.example.makhrijal_hurf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    Button learnButton,practiceButton,testButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        learnButton=findViewById(R.id.learn);
        learnButton.setOnClickListener(this);
        practiceButton=findViewById(R.id.practice);
        practiceButton.setOnClickListener(this);
        testButton=findViewById(R.id.test);
        testButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.learn:
                intent = new Intent(this, LearningActivity.class);
                startActivity(intent);
                break;
            case R.id.practice:
                intent=new Intent(this,HomeActivity.class);
                startActivity(intent);
                break;
            case R.id.test:
                intent=new Intent(this,HomeActivity.class);
                startActivity(intent);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }
}