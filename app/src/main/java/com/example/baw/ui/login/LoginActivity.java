package com.example.baw.ui.login;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.content.Intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.baw.Data;
import com.example.baw.R;
import com.example.baw.ResultShow;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginActivity extends AppCompatActivity {

    EditText txtYourName, txtFileName;
    ImageButton nextScreenBtn;
    final static int RESULT_ACTIVITY = 1;
    ArrayList<Data> fileData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        nextScreenBtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String name = txtYourName.getText().toString().trim();
                String file = txtFileName.getText().toString();
                if(name.isEmpty()) {
                    txtYourName.setError("Name required");
                }
                else if(file.isEmpty()) {
                    txtFileName.setError("File Name required");
                }
                boolean flag = true;
                for(Data d:fileData) {
                    if (txtYourName.equals(d.getName()) && txtFileName.equals(d.getFILENAME())) {
                        Intent intent = new Intent();
                        intent.putExtra("Name", String.valueOf(txtYourName));
                        intent.putExtra("File Name", String.valueOf(txtFileName));
                        startActivityForResult(intent, RESULT_ACTIVITY);
                    }
                }
                if(flag) {
                    Toast.makeText(LoginActivity.this, "Data doesn't exist", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RESULT_ACTIVITY) {
            Data d = new Data();
            d.setName(data.getStringExtra("Name"));
            d.setId(data.getStringExtra("ID"));

            Toast.makeText(this,"Data added successfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, ResultShow.class);
        }
    }
    private void init()
    {
        txtYourName = findViewById(R.id.txtYourName);
         txtFileName = findViewById(R.id.txtFileName);
        nextScreenBtn = findViewById(R.id.nextScreenBtn);
        fileData = new ArrayList<>();
    }
}