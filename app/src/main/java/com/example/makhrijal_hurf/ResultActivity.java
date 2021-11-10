package com.example.makhrijal_hurf;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ResultActivity extends AppCompatActivity {
    HashMap<String,String> TotalQuestions,SolvedQuestions;
   // ArrayList<String> list;
    TextView question,wrong,score,letter1,letter2,letter3,letter4,letter5,letter6,letter7,letter8,
            letter9,letter10,answer1,answer2,answer3,answer4,answer5,answer6,answer7,answer8,
    answer9,answer10,marked1,marked2,marked3,marked4,marked5,marked6,marked7,marked8,marked9,marked10,attempt;
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
        attempt=findViewById(R.id.attempt);
        marked1=findViewById(R.id.marked1);
        answer1=findViewById(R.id.answer1);
        letter1=findViewById(R.id.letter1);

        Bundle bundle = this.getIntent().getExtras();
        if(bundle!=null)
        {
           TotalQuestions= (HashMap<String, String>) bundle.getSerializable("Questions");
           SolvedQuestions= (HashMap<String, String>) bundle.getSerializable("Solved");
        }
        totalAttampt=SolvedQuestions.size();
        Object key;
        String ans;
        String marked="";
        for(int i=0;i<10;i++)
        {
            key=TotalQuestions.keySet().toArray()[i];
            ans=TotalQuestions.get(key);
            if(SolvedQuestions.containsKey(key))
            {
                marked=SolvedQuestions.get(key);
                if(ans.equals(marked))
                {
                    totalCorrect++;
                }
                else
                {
                    totalWrong++;
                }
            }
            if(i==1)
            {
                marked1.setText(marked);
                letter1.setText(""+key);
                answer1.setText(ans);
            }
        }
        attempt.setText(""+totalAttampt);
        question.setText(""+TotalQuestions.size());
        wrong.setText(""+totalWrong);
        score.setText(""+totalCorrect);
    }
}