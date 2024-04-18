package com.example.moviedex.Search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviedex.R;
import com.example.moviedex.Search.InputToFile.MovieModel;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    // creating a variable for array list and context.
    private ArrayList<MovieModel> courseModelArrayList;

    // creating a constructor for our variables.
    public MovieAdapter(ArrayList<MovieModel> courseModelArrayList, Context context) {
        this.courseModelArrayList = courseModelArrayList;
    }

    // method for filtering our recyclerview items.
    public void filterList(ArrayList<MovieModel> filterlist) {
        // below line is to add our filtered
        // list in our course array list.
        courseModelArrayList = filterlist;
        // below line is to notify our adapter
        // as change in recycler view data.
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // below line is to inflate our layout.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // setting data to our views of recycler view.
        MovieModel model = courseModelArrayList.get(position);
        holder.courseNameTV.setText(model.getMovie());
    }

    @Override
    public int getItemCount() {
        // returning the size of array list.
        return courseModelArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // creating variables for our views.
        private final TextView courseNameTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our views with their ids.
            courseNameTV = itemView.findViewById(R.id.idTVCourseName);

        }
    }
}