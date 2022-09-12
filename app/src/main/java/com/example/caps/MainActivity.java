package com.example.caps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.SQLOutput;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.transform.Source;

import ca.roumani.i2c.Country;
import ca.roumani.i2c.CountryDB;

public class MainActivity extends AppCompatActivity {
    private Game gm;
    private String question = "";
    private String answer = "";
    private int score = 0;
    private int qNum = 1;
    private String log = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gm = new Game();
        ask();
    }


    private void ask(){
        ((TextView) findViewById(R.id.qNum)).setText("Q# " + qNum);

        String qa = gm.qa();
        int split = qa.indexOf("?");
        question = qa.substring(0,split+1);
        answer = qa.substring(split+2);
        ((TextView) findViewById(R.id.question)).setText(question);
        ((TextView) findViewById(R.id.answer)).setText("");
    }

   public void onDone(View v){

        String ans = ((TextView) findViewById(R.id.answer)).getText().toString().toUpperCase();
        if (ans.equals(answer.toUpperCase())) score += 1;
        ((TextView) findViewById(R.id.score)).setText("SCORE = " + score);
        log = "\n" + ((TextView) findViewById(R.id.qNum)).getText().toString() + ": " + question + "\nYour answer: " + ans + "\nCorrect answer: " + answer + "\n" + log;
        ((TextView) findViewById(R.id.log)).setText(log);
        qNum++;
        if (qNum == 10) {
            ((TextView) findViewById(R.id.qNum)).setText("Game Over!");
            finish();
        }
        else ask();
    }



}