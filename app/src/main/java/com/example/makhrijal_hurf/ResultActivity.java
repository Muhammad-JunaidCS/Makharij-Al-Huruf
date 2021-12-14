package com.example.makhrijal_hurf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ResultActivity extends AppCompatActivity{
    HashMap<String,String> TotalQuestions,SolvedQuestions;
    Toolbar toolbar;
   // ArrayList<String> list;
//    TextView question,wrong,score,attempt;
    int totalCorrect,totalWrong,totalAttampt;
    List<Question> questionList=new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.share)
        {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            String send="I attempted "+totalAttampt+" out of 10 questions from which "+totalWrong+" were wrong and got score of "+totalCorrect+" in Makhārij-al-Hurūf App";
            sendIntent.putExtra(Intent.EXTRA_TEXT, send);
            sendIntent.setType("text/plain");

            Intent shareIntent = Intent.createChooser(sendIntent, null);
            startActivity(shareIntent);
            return true;
        }
        else
        {
            return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.result_menu,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        totalAttampt=0;
        totalWrong=0;
        totalCorrect=0;

        //Custom tool bar
        toolbar=findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        //back arrow
        ActionBar actionBar =getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

//        //binding of all text Views
//        question=findViewById(R.id.question);
//        wrong=findViewById(R.id.wrong);
//        score=findViewById(R.id.score);
//        attempt=findViewById(R.id.attempt);


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
        int length=TotalQuestions.size();
        for(int i=0;i<length;i++)
        {
            String marked="";
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
            Question q= new Question(key+"",ans,marked);
            questionList.add(q);
        }
        recyclerView = findViewById(R.id.myRecyclerView);

        recyclerView.setHasFixedSize(true);

        //LinearLayoutManager GridLayoutManager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new myRecyclerViewAdapter(questionList) ;
        recyclerView.setAdapter(adapter);
        //adapter.notifyDataSetChanged();

        //showing score
        totalAttampt=SolvedQuestions.size();
//        attempt.setText(""+totalAttampt);
//        question.setText(""+TotalQuestions.size());
//        wrong.setText(""+totalWrong);
//        score.setText(""+totalCorrect);
    }

}