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
    HashMap<Character,String> Halqiyah,Lahatiyah,ShajariyahHaafiyah,Tarfiyah,NitEeyah,Lisaveyah,Ghunna,NoName;
    HashMap<String,String> NoName1;
    Random rand;
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

        //populating all hashMaps
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
        //updateQuestion();
    }

    @Override
    public void onClick(View v) {
        updateQuestion();
    }
    private void updateQuestion()
    {
        rand = new Random();
        int randIndex = rand.nextInt(Halqiyah.size());
        Object Key = Halqiyah.keySet().toArray()[randIndex];
        Log.d("key",Halqiyah.get(Key));
        String ans=Halqiyah.get(Key);
        textView.setText(""+Key);
        //show correct answer at random option
        int randOption =rand.nextInt(4);
        if(randOption==0)
        {
            optionA.setText(ans);
        }
        else if(randOption==1)
        {
            optionB.setText(ans);
        }
        else if(randOption==2)
        {
            optionC.setText(ans);
        }
        else
        {
            optionD.setText(ans);
        }

    }
}