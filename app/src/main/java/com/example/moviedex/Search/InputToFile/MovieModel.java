package com.example.moviedex.Search.InputToFile;

public class MovieModel {

        // variables for our course
        // name and description.
        private String MovieInformation;

        // creating constructor for our variables.
        public MovieModel(String Movie) {
            this.MovieInformation = Movie;

        }

        // creating getter and setter methods.
        public String getMovie() {
            return MovieInformation;
        }

        public void setMovie(String Movie) {
            this.MovieInformation = Movie;
        }



}
