package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void goToSecondActivity(View view){

        //get users input and store into username variable
        EditText edtTxtName = findViewById(R.id.editTxtUsername);
        String username = edtTxtName.getText().toString();

        // Name validation - cannot be empty
        if (username.trim().isEmpty()) {
            Toast.makeText(this, "Please enter your name!", Toast.LENGTH_SHORT).show();
            edtTxtName.setText("");
            return;
        }
        //create the random number (1 to 100)
        Random random = new Random();
        int luckyNumber = random.nextInt(100) + 1;

        //create the Intent and pass each data
        Intent intent = new Intent(this, SecondActivity.class );
        intent.putExtra("USERNAME", username);
        intent.putExtra("LUCKY_NUMBER", luckyNumber);

        //go-to second page
        startActivity(intent);
    }

}