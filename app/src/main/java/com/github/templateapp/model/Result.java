package com.github.templateapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {

    @SerializedName("results")
    @Expose
    private List<Planets> planets = null;

    public List<Planets> getPlanets() {
        return planets;
    }
}
