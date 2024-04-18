package com.example.moviedex;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moviedex.Search.FileToSearch.GetMovieData;
import com.example.moviedex.Search.MovieAdapter;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class WhatToWatch extends AppCompatActivity {

        DatePickerDialog datePickerDialog;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_whattowatch);
            getSupportActionBar().hide();
            Spinner spinnerTesting = findViewById(R.id.GoToMood);

            ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this, R.array.DropdownItems, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
            spinnerTesting.setAdapter(adapter);


            Button whattowatchButton = (Button) findViewById(R.id.Random);
            whattowatchButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    GetMovieData MovieData = new GetMovieData();

                    String[] MovieLog = MovieData.MovieLog(getApplicationContext());
                    TextView textView = (TextView) findViewById(R.id.PickedItem);
                    textView.setText(PickMovie(MovieLog));
                }
            });




        }
        private String PickMovie(String[] MovieArray){
            double weight = .1; double totalWeight = 0;
            // THIS IS GOING THE CHANGE
        ArrayList<DataTypeMovie> movieData = new ArrayList<DataTypeMovie>();
            for(int i = 0; i < MovieArray.length-1; i++) {
                totalWeight = weight + totalWeight;
                weight = weight+weight;
                DataTypeMovie Movie = new DataTypeMovie(totalWeight,MovieArray[i]);
                movieData.add(Movie);
            }
            Random rand = new Random(System.currentTimeMillis());
            int randomChoice = rand.nextInt((int) totalWeight);
            for(int i = 0; i <= MovieArray.length-1; i++) {
                DataTypeMovie temp = movieData.get(i);
                if(temp.getWeight()>=randomChoice)
                {
                    Log.d("rand: ", String.valueOf(randomChoice));
                    Log.d("weight: ", Double.toString(temp.getWeight()));
                    return temp.getItem();
                }
            }
                return null;
        }
    }

      /*  private void configureBACKButton(){

            Button BackButton = (Button) findViewById(R.id.BackButton);
            BackButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(com.example.moviedex.AddActivity.this, MainActivity.class));
                }

            });*/







