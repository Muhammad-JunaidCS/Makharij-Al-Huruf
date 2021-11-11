package com.example.makhrijal_hurf;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener{
    HashMap<String,String> TotalQuestions,SolvedQuestions;
   // ArrayList<String> list;
    TextView question,wrong,score,letter1,letter2,letter3,letter4,letter5,letter6,letter7,letter8,
            letter9,letter10,answer1,answer2,answer3,answer4,answer5,answer6,answer7,answer8,
    answer9,answer10,marked1,marked2,marked3,marked4,marked5,marked6,marked7,marked8,marked9,marked10,attempt;
    Button share;
    int totalCorrect,totalWrong,totalAttampt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        totalAttampt=0;
        totalWrong=0;
        totalCorrect=0;

        //binding button
        share=findViewById(R.id.share);
        share.setOnClickListener(this);

        //binding of all text Views
        question=findViewById(R.id.question);
        wrong=findViewById(R.id.wrong);
        score=findViewById(R.id.score);
        attempt=findViewById(R.id.attempt);

        marked1=findViewById(R.id.marked1);
        answer1=findViewById(R.id.answer1);
        letter1=findViewById(R.id.letter1);

        marked2=findViewById(R.id.marked2);
        answer2=findViewById(R.id.answer2);
        letter2=findViewById(R.id.letter2);

        marked3=findViewById(R.id.marked3);
        answer3=findViewById(R.id.answer3);
        letter3=findViewById(R.id.letter3);

        marked4=findViewById(R.id.marked4);
        answer4=findViewById(R.id.answer4);
        letter4=findViewById(R.id.letter4);

        marked5=findViewById(R.id.marked5);
        answer5=findViewById(R.id.answer5);
        letter5=findViewById(R.id.letter5);

        marked6=findViewById(R.id.marked6);
        answer6=findViewById(R.id.answer6);
        letter6=findViewById(R.id.letter6);

        marked7=findViewById(R.id.marked7);
        answer7=findViewById(R.id.answer7);
        letter7=findViewById(R.id.letter7);

        marked8=findViewById(R.id.marked8);
        answer8=findViewById(R.id.answer8);
        letter8=findViewById(R.id.letter8);

        marked9=findViewById(R.id.marked9);
        answer9=findViewById(R.id.answer9);
        letter9=findViewById(R.id.letter9);

        marked10=findViewById(R.id.marked10);
        answer10=findViewById(R.id.answer10);
        letter10=findViewById(R.id.letter10);

        //Extracting data from bundle
        Bundle bundle = this.getIntent().getExtras();
        if(bundle!=null)
        {
           TotalQuestions= (HashMap<String, String>) bundle.getSerializable("Questions");
           SolvedQuestions= (HashMap<String, String>) bundle.getSerializable("Solved");
        }

        //Showing mcqs data
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
            switch (i)
            {
                case 0:
                    marked1.setText(marked);
                    letter1.setText(""+key);
                    answer1.setText(ans);
                    break;
                case 1:
                    marked2.setText(marked);
                    letter2.setText(""+key);
                    answer2.setText(ans);
                    break;
                case 2:
                    marked3.setText(marked);
                    letter3.setText(""+key);
                    answer3.setText(ans);
                    break;
                case 3:
                    marked4.setText(marked);
                    letter4.setText(""+key);
                    answer4.setText(ans);
                    break;
                case 4:
                    marked5.setText(marked);
                    letter5.setText(""+key);
                    answer5.setText(ans);
                    break;
                case 5:
                    marked6.setText(marked);
                    letter6.setText(""+key);
                    answer6.setText(ans);
                    break;
                case 6:
                    marked7.setText(marked);
                    letter7.setText(""+key);
                    answer7.setText(ans);
                    break;
                case 7:
                    marked8.setText(marked);
                    letter8.setText(""+key);
                    answer8.setText(ans);
                    break;
                case 8:
                    marked9.setText(marked);
                    letter9.setText(""+key);
                    answer9.setText(ans);
                    break;
                case 9:
                    marked10.setText(marked);
                    letter10.setText(""+key);
                    answer10.setText(ans);
                    break;
            }

        }

        //showing score
        totalAttampt=SolvedQuestions.size();
        attempt.setText(""+totalAttampt);
        question.setText(""+TotalQuestions.size());
        wrong.setText(""+totalWrong);
        score.setText(""+totalCorrect);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.share)
        {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            String send="I attempted "+attempt.getText()+" out of 10 questions from which "+wrong.getText()+" were wrong and got score of "+score.getText()+" in Makhārij-al-Hurūf App";
            sendIntent.putExtra(Intent.EXTRA_TEXT, send);
            sendIntent.setType("text/plain");

            Intent shareIntent = Intent.createChooser(sendIntent, null);
            startActivity(shareIntent);
        }
    }
}