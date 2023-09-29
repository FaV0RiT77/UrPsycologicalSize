package com.example.urpsycologicalsize;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class SizeActivity extends AppCompatActivity {
    private TextView name_tv, result_tv, quote_tv;
    private Button share_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_size);

        name_tv = findViewById(R.id.name_tv);
        result_tv = findViewById(R.id.result_tv);
        quote_tv = findViewById(R.id.quote_tv);
        share_btn = findViewById(R.id.share_btn);
        //Receive the intent by key "name"
        String name = getIntent().getStringExtra("name").concat(",");
        name_tv.setText(name);
        int number = getRandomNumber();
        result_tv.setText(Integer.toString(number));
        quote_tv.setText(getQuote(number));

        share_btn.setOnClickListener(v -> {
            shareData(name, number, getQuote(number));
        });
    }

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(30);
    }

    public String getQuote(int number) {
        String quote;
        switch(number) {
            case 1, 2, 4, 5 -> quote = "\"Bigger is better\" is a myth and the psychological Size of a person does not affect the amount of pleasure he feels, and it has minimal effect on the amount of pleasure for his partner.\"";
            case 6, 7, 8, 11, 12 -> quote = "\"Size is strictly a case of mind over matter. If you don't mind, it doesn't matter.\"";
            case 13, 14, 15, 18, 19 -> quote = "\"Size is not a destination but a process. It's about how you drive, not where you're going.\"";
            case 20, 21, 22, 24 -> quote = "\"Size grows by exercise, and contrary to common belief, is more powerful in the mature than in the young.\"";
            case 25, 26, 27, 28, 29, 30 -> quote = "\"Size is not like height or weight that we can just easily gauge with a metal instrument and determine its precise measure. It may have contrasted meanings for various cultures, age bracket, and skillsets.\"";
            default -> {
                return "\"You grow up on the day you have your first real laugh at your Size\"";
            }
        }
        return quote;
    }

    public void shareData(String name, int number, String quote) {
        // Implicit intents
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        i.putExtra(Intent.EXTRA_SUBJECT, name + " has a Size!");
        i.putExtra(Intent.EXTRA_TEXT, "Their Size is: " + number + "\n" + quote);

        startActivity(Intent.createChooser(i, "Choose a platform"));
    }
}