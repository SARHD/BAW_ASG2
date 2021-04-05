package com.example.baw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ResultShow extends AppCompatActivity {
    TextView results;
    ImageButton Back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_show);
        init();

        Intent i = getIntent();
        String text = results.getText().toString();
        results.setText(text+"\n"+i.getStringExtra("Name"));

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                Intent intent = new Intent(ResultShow.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void init() {
        results = findViewById(R.id.results);
        Back = findViewById(R.id.Back);
    }
    }