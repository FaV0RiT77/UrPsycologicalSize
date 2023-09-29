package com.example.urpsycologicalsize;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText name_et;
    private Button signin_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name_et = findViewById(R.id.name_et);
        signin_btn = findViewById(R.id.signin_btn);

        signin_btn.setOnClickListener(v -> {
            String name = name_et.getText().toString();

            // Explicit Intent
            Intent i = new Intent(getApplicationContext(), SizeActivity.class);
            // passing the name
            i.putExtra("name", name);

            startActivity(i);
        });
    }
}