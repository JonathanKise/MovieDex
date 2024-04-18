package com.example.moviedex.Search.FileToSearch;


import android.content.Context;


public class GetMovieData {
    public String[] MovieLog(Context context) {


        ReadMovieDataFile Read = new ReadMovieDataFile();


        return Read.readMovieLogs(context);
    };
}
