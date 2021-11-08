package com.example.makhrijal_hurf;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class PracticeActivity extends AppCompatActivity implements View.OnClickListener{
    Button optionA,optionB,optionC,optionD;
    TextView textView;
    HashMap<Character,String> Halqiyah;
    Random rand;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        textView=findViewById(R.id.textView3);
        optionA=findViewById(R.id.optionA);
        optionA.setOnClickListener(this);
        optionB=findViewById(R.id.optionB);
        optionB.setOnClickListener(this);
        optionC=findViewById(R.id.optionC);
        optionC.setOnClickListener(this);
        optionD=findViewById(R.id.optionD);
        optionD.setOnClickListener(this);
        Halqiyah = new HashMap<Character,String>();
        Halqiyah.put('أ',"End of Throat");
        Halqiyah.put('ہ',"End of Throat");
        Halqiyah.put('ع',"Middle of throat");
        Halqiyah.put('ح',"Middle of throat");
        Halqiyah.put('خ',"Start of throat");
        Halqiyah.put('غ',"Start of throat");
        updateQuestion();
    }

    @Override
    public void onClick(View v) {
        updateQuestion();
    }
    private void updateQuestion()
    {
        rand = new Random();
        int rNum = rand.nextInt(Halqiyah.size());
        Object Key = Halqiyah.keySet().toArray()[rNum];
        Log.d("key",Halqiyah.get(Key));
        String ans=Halqiyah.get(Key);
        textView.setText(""+Key);
        //show correct answer at random option
        int rOption =rand.nextInt(4);
        if(rOption==0)
        {
            optionA.setText(ans);
        }
        else if(rOption==1)
        {
            optionB.setText(ans);
        }
        else if(rOption==2)
        {
            optionC.setText(ans);
        }
        else
        {
            optionD.setText(ans);
        }

    }
}