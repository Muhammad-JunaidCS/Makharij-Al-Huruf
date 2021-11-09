package com.example.makhrijal_hurf;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ResultActivity extends AppCompatActivity {
    HashMap<String,String> hashMap;
    ArrayList<String> list;
    TextView question,wrong,score,letter1,letter2,letter3,letter4,letter5,letter6,letter7,letter8,
            letter9,letter10,answer1,answer2,answer3,answer4,answer5,answer6,answer7,answer8,
    answer9,answer10,marked1,marked2,marked3,marked4,marked5,marked6,marked7,marked8,marked9,marked10;
    int totalCorrect,totalWrong,totalAttampt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        totalAttampt=0;
        totalWrong=0;
        totalCorrect=0;

        question=findViewById(R.id.question);
        wrong=findViewById(R.id.wrong);
        score=findViewById(R.id.score);

        Bundle bundle = this.getIntent().getExtras();
        if(bundle!=null)
        {
           hashMap= (HashMap<String, String>) bundle.getSerializable("HashMap");
           list=bundle.getStringArrayList("list");
        }
        hashMap.size();
        list.size();
        Log.e("list size",""+list.size());
        Log.e("hashmap size",""+hashMap.size());
        Object key;
        String val;
        for(int i=0;i<10;i++)
        {
            key=hashMap.keySet().toArray()[i];
            val=hashMap.get(key);
            if(val.equals(list.get(i)))
            {
                totalCorrect++;
            }
            else
            {
                totalWrong++;
            }
        }
        question.setText("10");
        wrong.setText(""+totalWrong);
        score.setText(""+totalCorrect);
    }
}