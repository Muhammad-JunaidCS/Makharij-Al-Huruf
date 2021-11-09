package com.example.makhrijal_hurf;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

public class PracticeActivity extends AppCompatActivity implements View.OnClickListener{
    Button optionA,optionB,optionC,optionD,nextBut;
    TextView textView;
    HashMap<Character,String> Halqiyah,Lahatiyah,ShajariyahHaafiyah,Tarfiyah,NitEeyah,Lisaveyah,Ghunna,NoName;
    HashMap<String,String> NoName1,Answer;
    int correctOption;
    public static Stack<String> stack;
    public static final int GREEN=-16711936;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

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

        //initailizing stack
        stack=new Stack<String>();

        //setting all buttons background
        optionA.setBackgroundColor(-7829368);//gray color
        nextBut.setBackgroundColor(-7829368);
        optionB.setBackgroundColor(-7829368);
        optionC.setBackgroundColor(-7829368);
        optionD.setBackgroundColor( -7829368);




        //populating all hashMaps
        //Answer hashmap will be used to store correct letter and desc
        Answer = new HashMap<String,String>();
        Halqiyah = new HashMap<Character,String>();
        Halqiyah.put('أ',"End of Throat");
        Halqiyah.put('ہ',"End of Throat");
        Halqiyah.put('ع',"Middle of throat");
        Halqiyah.put('ح',"Middle of throat");
        Halqiyah.put('خ',"Start of throat");
        Halqiyah.put('غ',"Start of throat");



        Lahatiyah= new HashMap<Character,String>();
        Lahatiyah.put('ق',"Base of Tongue which is near Uvula\ntouching the mouth roof");
        Lahatiyah.put('ک',"Portion of Tongue near its base\ntouching the roof of mouth");

        ShajariyahHaafiyah=new HashMap<Character,String>();
        ShajariyahHaafiyah.put('ج',"Tongue touching the center\nof the mouth roof");
        ShajariyahHaafiyah.put('ش',"Tongue touching the center\nof the mouth roof");
        ShajariyahHaafiyah.put('ی',"Tongue touching the center\nof the mouth roof");
        ShajariyahHaafiyah.put('ض',"One side of the tongue\ntouching the molar teeth");

        Tarfiyah=new HashMap<Character,String>();
        Tarfiyah.put('ل',"Rounded tip of the tongue touching the\nbase of the frontal 8 teeth");
        Tarfiyah.put('ن',"Rounded tip of the tongue touching the\nbase of the frontal 6 teeth");
        Tarfiyah.put('ر',"Rounded tip of the tongue and some\nportion near it touching the base of\nthe frontal 4 teeth");

        NitEeyah=new HashMap<Character,String>();
        NitEeyah.put('ت',"Tip of the tongue touching the base\nof the front 2 teeth");
        NitEeyah.put('د',"Tip of the tongue touching the base\nof the front 2 teeth");
        NitEeyah.put('ط',"Tip of the tongue touching the base\nof the front 2 teeth");

        Lisaveyah=new HashMap<Character,String>();
        Lisaveyah.put('ظ',"Tip of the tongue touching the tip\nof the frontal 2 teeth");
        Lisaveyah.put('ذ',"Tip of the tongue touching the tip\nof the frontal 2 teeth");
        Lisaveyah.put('ث',"Tip of the tongue touching the tip\nof the frontal 2 teeth");
        Lisaveyah.put('ص',"Tip of the tongue comes between the\nfront top and bottom teeth");
        Lisaveyah.put('ز',"Tip of the tongue comes between the\nfront top and bottom teeth");
        Lisaveyah.put('س',"Tip of the tongue comes between the\nfront top and bottom teeth");

        Ghunna=new HashMap<Character,String>();
        Ghunna.put('م',"While pronouncing the ending sound\nbring the vibration to the nose");
        Ghunna.put('ن',"While pronouncing the ending sound\nbring the vibration to the nose");

        NoName=new HashMap<Character,String>();
        NoName.put('ف',"Tip of the two upper jaw teeth touches\nthe inner part of the lower lip");
        NoName.put('ب',"Inner part of the both lips\ntouch each other");
        NoName.put('م',"Outer part of both lips touch\neach other");
        NoName.put('و',"Rounding both lips and not\nclosing the mouth");

        NoName1=new HashMap<String,String>();
        NoName1.put("با","Mouth empty space while speaking word");
        NoName1.put("بو","Mouth empty space while speaking word");
        NoName1.put("بى","Mouth empty space while speaking word");
        updateQuestion();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==correctOption)
        {
            findViewById(correctOption).setBackgroundColor(-16711936);//green color
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
            optionA.setClickable(false);
            optionB.setClickable(false);
            optionC.setClickable(false);
            optionD.setClickable(false);
        }
        else if(v.getId()==R.id.nextButton)
        {
            optionA.setClickable(true);
            optionB.setClickable(true);
            optionC.setClickable(true);
            optionD.setClickable(true);
            Answer.clear();
            stack.clear();
            updateQuestion();
        }

    }
    private void updateQuestion()
    {
        nextBut.setText("NEXT");
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
                break;
            case 1://selecting Lahatiyah
                randIndex = rand.nextInt(Lahatiyah.size());
                Key = Lahatiyah.keySet().toArray()[randIndex];
                ans=Lahatiyah.get(Key);
                textView.setText(""+Key);
                Answer.put(""+Key,ans);
                break;
            case 2://selecting ShajariyahHaafiyah
                randIndex = rand.nextInt(ShajariyahHaafiyah.size());
                Key = ShajariyahHaafiyah.keySet().toArray()[randIndex];
                ans=ShajariyahHaafiyah.get(Key);
                textView.setText(""+Key);
                Answer.put(""+Key,ans);
                break;
            case 3://selecting Tarfiyah
                randIndex = rand.nextInt(Tarfiyah.size());
                Key = Tarfiyah.keySet().toArray()[randIndex];
                ans=Tarfiyah.get(Key);
                textView.setText(""+Key);
                Answer.put(""+Key,ans);
                break;
            case 4://selecting NitEeyah
                randIndex = rand.nextInt(NitEeyah.size());
                Key = NitEeyah.keySet().toArray()[randIndex];
                ans=NitEeyah.get(Key);
                textView.setText(""+Key);
                Answer.put(""+Key,ans);
                break;
            case 5://selecting Lisaveyah
                randIndex = rand.nextInt(Lisaveyah.size());
                Key = Lisaveyah.keySet().toArray()[randIndex];
                ans=Lisaveyah.get(Key);
                textView.setText(""+Key);
                Answer.put(""+Key,ans);
                break;
            case 6://selecting Ghunna
                randIndex = rand.nextInt(Ghunna.size());
                Key = Ghunna.keySet().toArray()[randIndex];
                ans=Ghunna.get(Key);
                textView.setText(""+Key);
                Answer.put(""+Key,ans);
                break;
            case 7://selecting NoName
                randIndex = rand.nextInt(NoName.size());
                Key = NoName.keySet().toArray()[randIndex];
                ans=NoName.get(Key);
                textView.setText(""+Key);
                Answer.put(""+Key,ans);
                break;
            case 8://selecting NoName1
                randIndex = rand.nextInt(NoName1.size());
                Key = NoName1.keySet().toArray()[randIndex];
                ans=NoName1.get(Key);
                textView.setText(""+Key);
                Answer.put(""+Key,ans);
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
                getOption(optionB);
                getOption(optionC);
                getOption(optionD);
                break;
            case 1:
                correctOption=optionB.getId();
                optionB.setText(ans);
                getOption(optionA);
                getOption(optionC);
                getOption(optionD);
                break;
            case 2:
                correctOption=optionC.getId();
                optionC.setText(ans);
                getOption(optionA);
                getOption(optionB);
                getOption(optionD);
                break;
            case 3:
                correctOption=optionD.getId();
                optionD.setText(ans);
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
                    if(!ans.equals(option) && k!=Key && !stack.contains(option) )
                    {
                        flag=false;
                        b.setText(option);
                        stack.push(option);
                    }
                    break;
                case 1://selecting Lahatiyah
                    randIndex = rand.nextInt(Lahatiyah.size());
                    Key = Lahatiyah.keySet().toArray()[randIndex];
                    option=Lahatiyah.get(Key);
                    if(!ans.equals(option) && k!=Key && !stack.contains(option) )
                    {
                        flag=false;
                        b.setText(option);
                        stack.push(option);
                    }
                    break;
                case 2://selecting ShajariyahHaafiyah
                    randIndex = rand.nextInt(ShajariyahHaafiyah.size());
                    Key = ShajariyahHaafiyah.keySet().toArray()[randIndex];
                    option=ShajariyahHaafiyah.get(Key);
                    if(!ans.equals(option) && k!=Key && !stack.contains(option) )
                    {
                        flag=false;
                        b.setText(option);
                        stack.push(option);
                    }
                    break;
                case 3://selecting Tarfiyah
                    randIndex = rand.nextInt(Tarfiyah.size());
                    Key = Tarfiyah.keySet().toArray()[randIndex];
                    option=Tarfiyah.get(Key);
                    if(!ans.equals(option) && k!=Key && !stack.contains(option) )
                    {
                        flag=false;
                        b.setText(option);
                        stack.push(option);
                    }
                    break;
                case 4://selecting NitEeyah
                    randIndex = rand.nextInt(NitEeyah.size());
                    Key = NitEeyah.keySet().toArray()[randIndex];
                    option=NitEeyah.get(Key);
                    if(!ans.equals(option) && k!=Key && !stack.contains(option) )
                    {
                        flag=false;
                        b.setText(option);
                        stack.push(option);
                    }
                    break;
                case 5://selecting Lisaveyah
                    randIndex = rand.nextInt(Lisaveyah.size());
                    Key = Lisaveyah.keySet().toArray()[randIndex];
                    option=Lisaveyah.get(Key);
                    if(!ans.equals(option) && k!=Key && !stack.contains(option) )
                    {
                        flag=false;
                        b.setText(option);
                        stack.push(option);
                    }
                    break;
                case 6://selecting Ghunna
                    randIndex = rand.nextInt(Ghunna.size());
                    Key = Ghunna.keySet().toArray()[randIndex];
                    option=Ghunna.get(Key);
                    if(!ans.equals(option) && k!=Key && !stack.contains(option) )
                    {
                        flag=false;
                        b.setText(option);
                        stack.push(option);
                    }
                    break;
                case 7://selecting NoName
                    randIndex = rand.nextInt(NoName.size());
                    Key = NoName.keySet().toArray()[randIndex];
                    option=NoName.get(Key);
                    if(!ans.equals(option) && k!=Key && !stack.contains(option) )
                    {
                        flag=false;
                        b.setText(option);
                        stack.push(option);
                    }
                    break;
                case 8://selecting NoName1
                    randIndex = rand.nextInt(NoName1.size());
                    Key = NoName1.keySet().toArray()[randIndex];
                    option=NoName1.get(Key);
                    if(!ans.equals(option) && k!=Key && !stack.contains(option) )
                    {
                        flag=false;
                        b.setText(option);
                        stack.push(option);
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