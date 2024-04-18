package com.example.moviedex.Search.FileToSearch;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ReadMovieDataFile {
    public String[] readMovieLogs(Context context) {
        ArrayList<String> movieList = new ArrayList<String>();

        try {
            InputStream inputStream = context.openFileInput("MovieLogs.txt");
            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    movieList.add(line);
                }

                inputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] movie = new String[movieList.size()];
        movieList.toArray(movie);

        return movie;
    }
}
