package com.example.caps;

import java.util.List;
import java.util.Map;

import ca.roumani.i2c.Country;
import ca.roumani.i2c.CountryDB;

public class Game {

    private CountryDB db;

    public Game() {
        this.db = new CountryDB();
    }

    public String qa(){
        String questionWithAnswer;
        List<String> capitals = db.getCapitals();
        int n = capitals.size();
        int index = (int) (n * Math.random());
        String c = capitals.get(index);
        Map<String, Country> data = db.getData();
        Country ref = data.get(c);
        if (Math.random() < 0.5){
            questionWithAnswer  = "What is the capital of " + ref.getName() + "?\n"  + c;
        } else {
            questionWithAnswer = c + " is the capital of?\n" + ref.getName();
        }
        return questionWithAnswer;
    }
}
