package edu.iest.registrodeusuario.models;

import com.google.gson.annotations.SerializedName;

public class Carrera {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("date")
    private String date;
    //private List<Float> distances;
    @SerializedName("image")
    private String image;

    private String Description;


    public String getID() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String getImage() {
        return this.image;
    }

    private void setImage(String image) {
        this.image = image;
    }
/*
    public List<Float> getDistances() {
        return distances;
    }

    public void setDistances(List<Float> distances) {
        this.distances = distances;
    }
*/
    public void setDescription(String description) {
        Description = description;
    }

    public String getDescription() {
        return Description;
    }
}
