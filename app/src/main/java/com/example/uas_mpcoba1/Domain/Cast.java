package com.example.uas_mpcoba1.Domain;


import java.io.Serializable;

public class Cast implements Serializable {
    private String Actor;

    // Default constructor
    public Cast() {
    }

    // Getter and Setter

    public String getActor() {
        return Actor;
    }

    public void setActor(String actor) {
        Actor = actor;
    }
}

