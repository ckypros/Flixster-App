 package com.ckypros.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    String backdropPath;
    String posterPath;
    String title;
    String overview;

    public Movie(JSONObject jsonObject) throws JSONException {
        this.backdropPath = jsonObject.getString("backdrop_path");
        this.posterPath = jsonObject.getString("poster_path");
        this.title = jsonObject.getString("title");
        this.overview = jsonObject.getString("overview");
    }

    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < movieJsonArray.length(); i++) {
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }

    public String getPosterPath() {
        // as per the API config, posterWidth can be w92, w154, w185, w342, w500, w780, or original
        String posterWidth = "w342";
        return String.format("https://image.tmdb.org/t/p/%s/%s", posterWidth, this.posterPath);
    }

    public String getBackdropPath() {
        String backdropWidth = "w342";
        return String.format("https://image.tmdb.org/t/p/%s/%s", backdropWidth, this.backdropPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }
}
