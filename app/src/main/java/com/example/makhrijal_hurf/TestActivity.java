package com.example.makhrijal_hurf;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {
    Button optionA,optionB,optionC,optionD,nextBut;
    TextView textView,textView1;
    HashMap<Character,String> Halqiyah,Lahatiyah,ShajariyahHaafiyah,Tarfiyah,NitEeyah,Lisaveyah,Ghunna,NoName;
    HashMap<String,String> NoName1,Answer,TotalQuestion,SolvedQuestion;
    int correctOption,questionNo;
  //  public static Stack<String> stack;
    public static final int GREEN=-16711936;
    ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        questionNo=1;
        //setting click listener to all buttons
        textView=findViewById(R.id.textView3);
        optionA=findViewById(R.id.optionA);
        optionA.setOnClickListener(this);
        optionB=findViewById(R.id.optionB);
        optionB.setOnClickListener(this);
        optionC=findViewById(R.id.optionC);
        optionC.setOnClickListener(this);
        optionD=findViewById(R.id.optionD);
        optionD.setOnClickListener(this);
        nextBut=findViewById(R.id.nextButton);
        nextBut.setOnClickListener(this);
        textView1=findViewById(R.id.textView5);

        nextBut.setText("NEXT");

        //list to main unique options
        list=new ArrayList<String>();

        //back arrow
        ActionBar actionBar =getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //setting all buttons background
        optionA.setBackgroundColor(-7829368);//gray color
        nextBut.setBackgroundColor(-7829368);
        optionB.setBackgroundColor(-7829368);
        optionC.setBackgroundColor(-7829368);
        optionD.setBackgroundColor( -7829368);

        //List will contain all the ans marked by user
        //list=new ArrayList<String>();

        //Answer hashmap will be used to store correct letter and desc
        Answer = new HashMap<String,String>();

        //TotalQuestion hashmap will contain all question and its correct ans
        TotalQuestion=new HashMap<String,String>();
        //SolvedQuestion will contain only solve question and their  marked option
        SolvedQuestion=new HashMap<String,String>();

        //populating all hashMaps
        Halqiyah = new HashMap<Character,String>();
        Halqiyah.put('??',"End of Throat");
        Halqiyah.put('??',"End of Throat");
        Halqiyah.put('??',"Middle of throat");
        Halqiyah.put('??',"Middle of throat");
        Halqiyah.put('??',"Start of throat");
        Halqiyah.put('??',"Start of throat");



        Lahatiyah= new HashMap<Character,String>();
        Lahatiyah.put('??',"Base of Tongue which is near Uvula touching the mouth roof");
        Lahatiyah.put('??',"Portion of Tongue near its base touching the roof of mouth");

        ShajariyahHaafiyah=new HashMap<Character,String>();
        ShajariyahHaafiyah.put('??',"Tongue touching the center of the mouth roof");
        ShajariyahHaafiyah.put('??',"Tongue touching the center of the mouth roof");
        ShajariyahHaafiyah.put('??',"Tongue touching the center of the mouth roof");
        ShajariyahHaafiyah.put('??',"One side of the tongue touching the molar teeth");

        Tarfiyah=new HashMap<Character,String>();
        Tarfiyah.put('??',"Rounded tip of the tongue touching the base of the frontal 8 teeth");
        Tarfiyah.put('??',"Rounded tip of the tongue touching the base of the frontal 6 teeth");
        Tarfiyah.put('??',"Rounded tip of the tongue and some portion near it touching the base of\nthe frontal 4 teeth");

        NitEeyah=new HashMap<Character,String>();
        NitEeyah.put('??',"Tip of the tongue touching the base of the front 2 teeth");
        NitEeyah.put('??',"Tip of the tongue touching the base of the front 2 teeth");
        NitEeyah.put('??',"Tip of the tongue touching the base of the front 2 teeth");

        Lisaveyah=new HashMap<Character,String>();
        Lisaveyah.put('??',"Tip of the tongue touching the tip of the frontal 2 teeth");
        Lisaveyah.put('??',"Tip of the tongue touching the tip of the frontal 2 teeth");
        Lisaveyah.put('??',"Tip of the tongue touching the tip of the frontal 2 teeth");
        Lisaveyah.put('??',"Tip of the tongue comes between the front top and bottom teeth");
        Lisaveyah.put('??',"Tip of the tongue comes between the front top and bottom teeth");
        Lisaveyah.put('??',"Tip of the tongue comes between the front top and bottom teeth");

        Ghunna=new HashMap<Character,String>();
        Ghunna.put('??',"While pronouncing the ending sound bring the vibration to the nose");
        Ghunna.put('??',"While pronouncing the ending sound bring the vibration to the nose");

        NoName=new HashMap<Character,String>();
        NoName.put('??',"Tip of the two upper jaw teeth touches the inner part of the lower lip");
        NoName.put('??',"Inner part of the both lips touch each other");
        NoName.put('??',"Outer part of both lips touch each other");
        NoName.put('??',"Rounding both lips and not closing the mouth");

        NoName1=new HashMap<String,String>();
        NoName1.put("????","Mouth empty space while speaking word");
        NoName1.put("????","Mouth empty space while speaking word");
        NoName1.put("????","Mouth empty space while speaking word");

        if (savedInstanceState!= null)
        {
            Answer= (HashMap<String, String>) savedInstanceState.getSerializable("StoreAnswer");
            Object k;
            textView.setText(""+Answer.keySet().toArray()[0]);
            TotalQuestion=(HashMap<String, String>) savedInstanceState.getSerializable("TotalQuest");
            SolvedQuestion=(HashMap<String, String>) savedInstanceState.getSerializable("SolvedQuest");

            correctOption=savedInstanceState.getInt("CorrectOpt");
            optionA.setText(savedInstanceState.getString("optA"));
            optionB.setText(savedInstanceState.getString("optB"));
            optionC.setText(savedInstanceState.getString("optC"));
            optionD.setText(savedInstanceState.getString("optD"));
            questionNo=savedInstanceState.getInt("QuestNo");
            if(questionNo==10)
            {
                nextBut.setText("Finish");
            }
            textView1.setText(""+questionNo);
        }
        else
        {
            updateQuestion();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("StoreAnswer",Answer);
        bundle.putSerializable("TotalQuest",TotalQuestion);
        bundle.putSerializable("SolvedQuest",SolvedQuestion);
        bundle.putInt("QuestNo",questionNo);
        bundle.putInt("CorrectOpt",correctOption);
        bundle.putString("optA",""+optionA.getText());
        bundle.putString("optB",""+optionB.getText());
        bundle.putString("optC",""+optionC.getText());
        bundle.putString("optD",""+optionD.getText());
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==correctOption)
        {
            findViewById(correctOption).setBackgroundColor(-16711936);//green color
            Button b=findViewById(correctOption);
           // list.add((String) b.getText());
            SolvedQuestion.put(""+textView.getText(),(String) b.getText());
            //TotalQuestion.put(""+textView.getText(),(String) b.getText());
            optionA.setClickable(false);
            optionB.setClickable(false);
            optionC.setClickable(false);
            optionD.setClickable(false);
        }
        else if(v.getId()!=correctOption && (v.getId()==R.id.optionA||v.getId()==R.id.optionB||
                v.getId()==R.id.optionC||v.getId()==R.id.optionD))
        {
            findViewById(v.getId()).setBackgroundColor( -65536);//red color
            findViewById(correctOption).setBackgroundColor(GREEN);//green color
            Button b=findViewById(v.getId());
           // list.add((String) b.getText());
            SolvedQuestion.put(""+textView.getText(),(String) b.getText());
            //TotalQuestion.put(""+textView.getText(),(String) b.getText());
            optionA.setClickable(false);
            optionB.setClickable(false);
            optionC.setClickable(false);
            optionD.setClickable(false);
        }
        else if(v.getId()==R.id.nextButton && questionNo <10)
        {
            if(questionNo==9)
            {
                nextBut.setText("Finish");
            }
            optionA.setClickable(true);
            optionB.setClickable(true);
            optionC.setClickable(true);
            optionD.setClickable(true);
            Answer.clear();
            list.clear();
            questionNo++;
            updateQuestion();
        }
        else
        {
            Answer.clear();
            list.clear();
            questionNo++;
            Log.i("Question List Size",""+TotalQuestion.size());
            Log.i("Solved List Size",""+SolvedQuestion.size());
            Bundle extras = new Bundle();
            Intent intent=new Intent(this,ResultActivity.class);
            extras.putSerializable("Questions",TotalQuestion);
            extras.putSerializable("Solved",SolvedQuestion);
            intent.putExtras(extras);
            startActivity(intent);
        }

    }
    private void updateQuestion()
    {
        textView1.setText(""+questionNo);
        Random rand;
        int randHashMAps;
        int randIndex;
        int randOption;
        String ans;
        Object Key;
        rand= new Random();
        randHashMAps=rand.nextInt(9);
        switch(randHashMAps)
        {
            case 0://selecting Halqiyah
                randIndex = rand.nextInt(Halqiyah.size());
                Key = Halqiyah.keySet().toArray()[randIndex];
                ans=Halqiyah.get(Key);
                textView.setText(""+Key);
                Answer.put(""+Key,ans);
                if(TotalQuestion.containsKey(""+Key))
                {
                    updateQuestion();
                }
                TotalQuestion.put(""+Key,ans);
                break;
            case 1://selecting Lahatiyah
                randIndex = rand.nextInt(Lahatiyah.size());
                Key = Lahatiyah.keySet().toArray()[randIndex];
                ans=Lahatiyah.get(Key);
                textView.setText(""+Key);
                Answer.put(""+Key,ans);
                if(TotalQuestion.containsKey(""+Key))
                {
                    updateQuestion();
                }
                TotalQuestion.put(""+Key,ans);
                break;
            case 2://selecting ShajariyahHaafiyah
                randIndex = rand.nextInt(ShajariyahHaafiyah.size());
                Key = ShajariyahHaafiyah.keySet().toArray()[randIndex];
                ans=ShajariyahHaafiyah.get(Key);
                textView.setText(""+Key);
                Answer.put(""+Key,ans);
                if(TotalQuestion.containsKey(""+Key))
                {
                    updateQuestion();
                }
                TotalQuestion.put(""+Key,ans);
                break;
            case 3://selecting Tarfiyah
                randIndex = rand.nextInt(Tarfiyah.size());
                Key = Tarfiyah.keySet().toArray()[randIndex];
                ans=Tarfiyah.get(Key);
                textView.setText(""+Key);
                Answer.put(""+Key,ans);
                if(TotalQuestion.containsKey(""+Key))
                {
                    updateQuestion();
                }
                TotalQuestion.put(""+Key,ans);
                break;
            case 4://selecting NitEeyah
                randIndex = rand.nextInt(NitEeyah.size());
                Key = NitEeyah.keySet().toArray()[randIndex];
                ans=NitEeyah.get(Key);
                textView.setText(""+Key);
                Answer.put(""+Key,ans);
                if(TotalQuestion.containsKey(""+Key))
                {
                    updateQuestion();
                }
                TotalQuestion.put(""+Key,ans);
                break;
            case 5://selecting Lisaveyah
                randIndex = rand.nextInt(Lisaveyah.size());
                Key = Lisaveyah.keySet().toArray()[randIndex];
                ans=Lisaveyah.get(Key);
                textView.setText(""+Key);
                Answer.put(""+Key,ans);
                if(TotalQuestion.containsKey(""+Key))
                {
                    updateQuestion();
                }
                TotalQuestion.put(""+Key,ans);
                break;
            case 6://selecting Ghunna
                randIndex = rand.nextInt(Ghunna.size());
                Key = Ghunna.keySet().toArray()[randIndex];
                ans=Ghunna.get(Key);
                textView.setText(""+Key);
                Answer.put(""+Key,ans);
                if(TotalQuestion.containsKey(""+Key))
                {
                    updateQuestion();
                }
                TotalQuestion.put(""+Key,ans);
                break;
            case 7://selecting NoName
                randIndex = rand.nextInt(NoName.size());
                Key = NoName.keySet().toArray()[randIndex];
                ans=NoName.get(Key);
                textView.setText(""+Key);
                Answer.put(""+Key,ans);
                if(TotalQuestion.containsKey(""+Key))
                {
                    updateQuestion();
                }
                TotalQuestion.put(""+Key,ans);
                break;
            case 8://selecting NoName1
                randIndex = rand.nextInt(NoName1.size());
                Key = NoName1.keySet().toArray()[randIndex];
                ans=NoName1.get(Key);
                textView.setText(""+Key);
                Answer.put(""+Key,ans);
                if(TotalQuestion.containsKey(""+Key))
                {
                    updateQuestion();
                }
                TotalQuestion.put(""+Key,ans);
                break;
            default:
                randIndex=0;
                randOption=0;
                ans="";
                break;
        }

        optionA.setBackgroundColor(-7829368);//gray color
        optionB.setBackgroundColor(-7829368);
        optionC.setBackgroundColor(-7829368);
        optionD.setBackgroundColor( -7829368);

        //show correct answer at random option
        Random rand1 = new Random();
        randOption =rand1.nextInt(4);
        switch (randOption)
        {
            case 0:
                correctOption=optionA.getId();
                optionA.setText(ans);
                list.add(ans);
                getOption(optionB);
                getOption(optionC);
                getOption(optionD);
                break;
            case 1:
                correctOption=optionB.getId();
                optionB.setText(ans);
                list.add(ans);
                getOption(optionA);
                getOption(optionC);
                getOption(optionD);
                break;
            case 2:
                correctOption=optionC.getId();
                optionC.setText(ans);
                list.add(ans);
                getOption(optionA);
                getOption(optionB);
                getOption(optionD);
                break;
            case 3:
                correctOption=optionD.getId();
                optionD.setText(ans);
                list.add(ans);
                getOption(optionA);
                getOption(optionB);
                getOption(optionC);
        }
    }

    public void getOption(View v)
    {
        Button b = findViewById(v.getId());
        Object k = Answer.keySet().toArray()[0];
        String ans =Answer.get(k);
        Random rand;
        int randIndex;
        String option;
        Object Key;
        boolean flag=true;
        while (flag)
        {
            rand= new Random();
            int randHashMAps=rand.nextInt(9);
            switch(randHashMAps)
            {
                case 0://selecting Halqiyah
                    randIndex = rand.nextInt(Halqiyah.size());
                    Key = Halqiyah.keySet().toArray()[randIndex];
                    option=Halqiyah.get(Key);
                    if(!ans.equals(option) && k!=Key && !list.contains(option) )
                    {
                        flag=false;
                        b.setText(option);
                        list.add(option);
                    }
                    break;
                case 1://selecting Lahatiyah
                    randIndex = rand.nextInt(Lahatiyah.size());
                    Key = Lahatiyah.keySet().toArray()[randIndex];
                    option=Lahatiyah.get(Key);
                    if(!ans.equals(option) && k!=Key && !list.contains(option) )
                    {
                        flag=false;
                        b.setText(option);
                        list.add(option);
                    }
                    break;
                case 2://selecting ShajariyahHaafiyah
                    randIndex = rand.nextInt(ShajariyahHaafiyah.size());
                    Key = ShajariyahHaafiyah.keySet().toArray()[randIndex];
                    option=ShajariyahHaafiyah.get(Key);
                    if(!ans.equals(option) && k!=Key && !list.contains(option) )
                    {
                        flag=false;
                        b.setText(option);
                        list.add(option);
                    }
                    break;
                case 3://selecting Tarfiyah
                    randIndex = rand.nextInt(Tarfiyah.size());
                    Key = Tarfiyah.keySet().toArray()[randIndex];
                    option=Tarfiyah.get(Key);
                    if(!ans.equals(option) && k!=Key && !list.contains(option) )
                    {
                        flag=false;
                        b.setText(option);
                        list.add(option);
                    }
                    break;
                case 4://selecting NitEeyah
                    randIndex = rand.nextInt(NitEeyah.size());
                    Key = NitEeyah.keySet().toArray()[randIndex];
                    option=NitEeyah.get(Key);
                    if(!ans.equals(option) && k!=Key && !list.contains(option) )
                    {
                        flag=false;
                        b.setText(option);
                        list.add(option);
                    }
                    break;
                case 5://selecting Lisaveyah
                    randIndex = rand.nextInt(Lisaveyah.size());
                    Key = Lisaveyah.keySet().toArray()[randIndex];
                    option=Lisaveyah.get(Key);
                    if(!ans.equals(option) && k!=Key && !list.contains(option) )
                    {
                        flag=false;
                        b.setText(option);
                        list.add(option);
                    }
                    break;
                case 6://selecting Ghunna
                    randIndex = rand.nextInt(Ghunna.size());
                    Key = Ghunna.keySet().toArray()[randIndex];
                    option=Ghunna.get(Key);
                    if(!ans.equals(option) && k!=Key && !list.contains(option) )
                    {
                        flag=false;
                        b.setText(option);
                        list.add(option);
                    }
                    break;
                case 7://selecting NoName
                    randIndex = rand.nextInt(NoName.size());
                    Key = NoName.keySet().toArray()[randIndex];
                    option=NoName.get(Key);
                    if(!ans.equals(option) && k!=Key && !list.contains(option) )
                    {
                        flag=false;
                        b.setText(option);
                        list.add(option);
                    }
                    break;
                case 8://selecting NoName1
                    randIndex = rand.nextInt(NoName1.size());
                    Key = NoName1.keySet().toArray()[randIndex];
                    option=NoName1.get(Key);
                    if(!ans.equals(option) && k!=Key && !list.contains(option) )
                    {
                        flag=false;
                        b.setText(option);
                        list.add(option);
                    }
                    break;
            }
        }


    }
//    public void setOption(View button)
//    {
//        Button b = findViewById(button.getId());
//        String option = getRandomOption();
//        Object k = Answer.keySet().toArray()[0];
//        String ans =Answer.get(k);
//        while(option==ans)
//        {
//            option=getRandomOption();
//        }
//        b.setText(option);
//    }
//    public String getRandomOption()
//    {
//        Random rand;
//        int randIndex;
//        String option;
//        Object Key;
//        Object k = Answer.keySet().toArray()[0];
//        String correct = Answer.get(k);
//        rand= new Random();
//        int randHashMAps=rand.nextInt(9);
//        switch(randHashMAps)
//        {
//            case 0://selecting Halqiyah
//                randIndex = rand.nextInt(Halqiyah.size());
//                Key = Halqiyah.keySet().toArray()[randIndex];
//                option=Halqiyah.get(Key);
//                return option;
//            case 1://selecting Lahatiyah
//                randIndex = rand.nextInt(Lahatiyah.size());
//                Key = Lahatiyah.keySet().toArray()[randIndex];
//                option=Lahatiyah.get(Key);
//                return option;
//            case 2://selecting ShajariyahHaafiyah
//                randIndex = rand.nextInt(ShajariyahHaafiyah.size());
//                Key = ShajariyahHaafiyah.keySet().toArray()[randIndex];
//                option=ShajariyahHaafiyah.get(Key);
//                return option;
//            case 3://selecting Tarfiyah
//                randIndex = rand.nextInt(Tarfiyah.size());
//                Key = Tarfiyah.keySet().toArray()[randIndex];
//                option=Tarfiyah.get(Key);
//                return option;
//            case 4://selecting NitEeyah
//                randIndex = rand.nextInt(NitEeyah.size());
//                Key = NitEeyah.keySet().toArray()[randIndex];
//                option=NitEeyah.get(Key);
//                return option;
//            case 5://selecting Lisaveyah
//                randIndex = rand.nextInt(Lisaveyah.size());
//                Key = Lisaveyah.keySet().toArray()[randIndex];
//                option=Lisaveyah.get(Key);
//                return option;
//            case 6://selecting Ghunna
//                randIndex = rand.nextInt(Ghunna.size());
//                Key = Ghunna.keySet().toArray()[randIndex];
//                option=Ghunna.get(Key);
//                return option;
//            case 7://selecting NoName
//                randIndex = rand.nextInt(NoName.size());
//                Key = NoName.keySet().toArray()[randIndex];
//                option=NoName.get(Key);
//                return option;
//            case 8://selecting NoName1
//                randIndex = rand.nextInt(NoName1.size());
//                Key = NoName1.keySet().toArray()[randIndex];
//                option=NoName1.get(Key);
//                return option;
//            default:
//                return "";
//        }
//
//    }
}
