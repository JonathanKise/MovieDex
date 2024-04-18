package com.example.moviedex;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity extends FragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homemenu);


        configureADDButton();
        configureSEARCHButton();
        configureWHATTOWATCHButton();
    }

    private void configureWHATTOWATCHButton() {
        Button whattowatchButton = (Button) findViewById(R.id.GoToWhatToWatch);
        whattowatchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startWhatToWatchActivity();
            }
            private void startWhatToWatchActivity(){
                Intent intent = new Intent(MainActivity.this,WhatToWatch.class);
                startActivity(intent);
            }
        });
    }

    private void configureADDButton() {

        Button addMovieButton = (Button) findViewById(R.id.GoToAdd);
        addMovieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAddMovieActivity();
            }

            private void startAddMovieActivity() {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

    }

    private void configureSEARCHButton() {
        Button searchMovieButton = (Button) findViewById(R.id.GoToSearch);

        searchMovieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
    }

    ;
}






