package com.example.makhrijal_hurf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button repoButton,appButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        repoButton=findViewById(R.id.button);
        repoButton.setOnClickListener(this);
        appButton=findViewById(R.id.button2);
        appButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//        switch (v.getId())
//        {
//            case R.id.button:
//                Intent intent = new Intent();
//        }
        if(v.getId()==R.id.button)
        {
            openWebPage("https://github.com/Muhammad-JunaidCS/Zakkat-Calculator-App");
        }
    }
    public void openWebPage(String url)
    {   Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }

}