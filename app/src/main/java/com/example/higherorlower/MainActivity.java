package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randNumber;

    public void generateRandomNumber(){
        Random rand=new Random();
        randNumber = rand.nextInt(50)+1;
    }

    public void guess(View view){
        EditText editText = (EditText) findViewById(R.id.editText);
        
        int guessedNumber = Integer.parseInt(editText.getText().toString());
        
        String message;
        
        if(guessedNumber > randNumber) {
            message = "Lower!";
        }else if(guessedNumber < randNumber){
            message = "Higher!";
        }else{
            message = "You Got It! Play Again!";
            generateRandomNumber();
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        Log.i("Entered Value",editText.getText().toString());
        Log.i("Random Generated Number",Integer.toString(randNumber));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateRandomNumber();
    }
}
