 package com.example.baw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.baw.ui.login.LoginActivity;

import static com.example.baw.R.id.imageButton;

 public class MainActivity extends AppCompatActivity {

    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(next);
            }
        });
    }



     private void init() {
        imageButton = findViewById(R.id.imageButton);
     }
 }