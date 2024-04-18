package com.example.moviedex;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviedex.Search.FileToSearch.GetMovieData;
import com.example.moviedex.Search.InputToFile.MovieModel;
import com.example.moviedex.Search.MovieAdapter;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    // creating variables for
    // our ui components.
    private RecyclerView courseRV;

    // variable for our adapter
    // class and array list
    private MovieAdapter adapter;
    private ArrayList<MovieModel> courseModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Search For Films....");
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable  = new ColorDrawable(Color.parseColor("#808080"));
        actionBar.setBackgroundDrawable(colorDrawable);

        // initializing our variables.
        courseRV = findViewById(R.id.idRVCourses);

        // calling method to
        // build recycler view.
        buildRecyclerView();
    }

    // calling on create option menu
    // layout to inflate our menu file.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // below line is to get our inflater
        MenuInflater inflater = getMenuInflater();

        // inside inflater we are inflating our menu file.
        inflater.inflate(R.menu.search_menu, menu);

        // below line is to get our menu item.
        MenuItem searchItem = menu.findItem(R.id.actionSearch);

        // getting search view of our item.
        SearchView searchView = (SearchView) searchItem.getActionView();

        // below line is to call set on query text listener method.
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // inside on query text change method we are
                // calling a method to filter our recycler view.
                filter(newText);
                return false;
            }
        });
        return true;
    }

    private void filter(String text) {
        // creating a new array list to filter our data.
        ArrayList<MovieModel> filteredlist = new ArrayList<MovieModel>();

        // running a for loop to compare elements.
        for (MovieModel item : courseModelArrayList) {
            // checking if the entered string matched with any item of our recycler view.
            if (item.getMovie().toLowerCase().contains(text.toLowerCase())) {
                // if the item is matched we are
                // adding it to our filtered list.
                filteredlist.add(item);
            }
        }
        if (filteredlist.isEmpty()) {
            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show();
        } else {
            // at last we are passing that filtered
            // list to our adapter class.
            adapter.filterList(filteredlist);
        }
    }

    private void buildRecyclerView() {
        GetMovieData G = new GetMovieData();
        String[] MovieINFO;
        MovieINFO = G.MovieLog(getApplicationContext());

        //THIS FLIPS THE MOVIE ARRAY
        int len = MovieINFO.length;
        for (int i = 0; i < len / 2; i++) {
            String temp = MovieINFO[i];
            MovieINFO[i] = MovieINFO[len - i - 1];
            MovieINFO[len - i - 1] = temp;
        }


        // below line we are creating a new array list
        courseModelArrayList = new ArrayList<MovieModel>();

        // below line is to add data to our array list.


        for(int i = 0; i < MovieINFO.length; i++){
            courseModelArrayList.add(new MovieModel(MovieINFO[i]));
        }

        // initializing our adapter class.
        adapter = new MovieAdapter(courseModelArrayList, SearchActivity.this);

        // adding layout manager to our recycler view.
        LinearLayoutManager manager = new LinearLayoutManager(this);
        courseRV.setHasFixedSize(true);

        // setting layout manager
        // to our recycler view.
        courseRV.setLayoutManager(manager);

        // setting adapter to
        // our recycler view.
        courseRV.setAdapter(adapter);
    }
}