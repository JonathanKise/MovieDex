package com.example.moviedex;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.moviedex.Search.InputToFile.SaveMovieDataFormat;

import java.io.IOException;
import java.util.Calendar;

public class AddActivity extends AppCompatActivity {
String Title = "ERROR NO DATA";
String Dates = "ERROR NO DATA";
String Watched = "ERROR NO DATA";
    EditText date;
    EditText TitleButton;

    DatePickerDialog datePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        getSupportActionBar().hide();
        configureSubmitButton();
        configureBACKButton();
        primarydatecode();


    }
    private void configureBACKButton(){

        Button BackButton = (Button) findViewById(R.id.BackButton);
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddActivity.this, MainActivity.class));
            }

        });


    }
    private void configureSubmitButton() {

        Button SummitButton = (Button) findViewById(R.id.SubmitButton);//get the id for button
        SummitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Writing All Of The String To the Text File
                configureTitleButton();
                configureWatchedButton();
                SaveMovieDataFormat M = new SaveMovieDataFormat();
                try {
                    //date to be sent to the file HERE!!
                    M.moviedata(Title, Dates, Watched, getApplicationContext());

                    //ADD MORE STUFF
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                //ON CLICK THIS SHOULD TAKE YOU BACK TO THE MAIN MENU
                startActivity(new Intent(AddActivity.this, MainActivity.class));
                //Toast.makeText(getApplicationContext(),"Wrote to file ", Toast.LENGTH_SHORT.show());
                // Toast.makeText(getBaseContext(), "Wrote To The File", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void configureDateButton(int year, int month, int day){
        Dates = String.valueOf(month) + "/" + String.valueOf(day) + "/" + String.valueOf(year);

    }
    private void configureTitleButton(){
        final EditText TitleButton = (EditText) findViewById(R.id.TitleButton);//get the id for edit text

                Title = TitleButton.getText().toString();

        }
    private void configureWatchedButton(){
        final EditText WatchedButton = (EditText) findViewById(R.id.WatchedButton);//get the id for edit text

                Watched = WatchedButton.getText().toString();
                //configureSummitButton(SummitButton);
    }
    private void primarydatecode(){

// initiate the date picker and a button
        date = (EditText) findViewById(R.id.dateButton);
        // perform click event on edit text
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(AddActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);
                                configureDateButton(year,monthOfYear + 1,dayOfMonth);
                            }

                        }, mYear, mMonth, mDay);
                datePickerDialog.show();


            }

        });



    }
}





