package com.example.uas_mpcoba1.Domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Film implements Serializable {
    private String Title;
    private String Description;
    private String Poster;
    private String Time;
    private Integer Year;
    private Double Imdb;
    private ArrayList<Cast> Casts;

    public Film() {


    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public Integer getYear() {
        return Year;
    }

    public void setYear(Integer year) {
        Year = year;
    }

    public Double getImdb() {
        return Imdb;
    }

    public void setImdb(Double imdb) {
        Imdb = imdb;
    }

    public ArrayList<Cast> getCasts() {
        return Casts;
    }

    public void setCasts(ArrayList<Cast> casts) {
        Casts = casts;
    }


}



