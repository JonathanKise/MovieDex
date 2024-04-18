package com.example.moviedex.Search.InputToFile;

import android.content.Context;

import java.io.IOException;

public class SaveMovieDataFormat
{
    public void moviedata(String Dates, String Title, String Watched,Context context) throws IOException
    {
        SaveMovieDateFile F = new SaveMovieDateFile();
        String Entry = Title + " - " + Watched + " - " + Dates + "\n";
        F.FileSave("MovieLogs.txt", Entry, context);
    }
}

