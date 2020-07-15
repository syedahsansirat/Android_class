package com.example.task13july2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String name= getIntent().getStringExtra("name");
        String messege= getIntent().getStringExtra("messege");
        textView = findViewById(R.id.textView2);
        textView.setText("Name: "+name+"\nMessege: "+messege);
    }
}