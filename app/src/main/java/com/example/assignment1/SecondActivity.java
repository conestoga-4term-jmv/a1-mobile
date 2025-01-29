package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity{
    String resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Get Intent
        Intent intent = getIntent();

        // Get data from Intent
        String username = intent.getStringExtra("USERNAME");
        int luckyNumber = intent.getIntExtra("LUCKY_NUMBER", 0);

        //set resultText to share
        resultText = username + " lucky number is: " + luckyNumber;

        // Show data in the screen
        TextView t1 = findViewById(R.id.textViewLuckyNumber);
        t1.setText(Integer.toString(luckyNumber));

    }

    public void shareLuckyNumber(View view) {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, resultText);
        shareIntent.setType("text/plain");

        // Create a chooser and start the activity
        Intent chooser = Intent.createChooser(shareIntent, "Share your Lucky Number");
        startActivity(chooser);
    }
}
