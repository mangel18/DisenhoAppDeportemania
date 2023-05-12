package edu.iest.registrodeusuario.models;

import com.google.gson.annotations.SerializedName;

public class CarreraBrief {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;

    @SerializedName("date")
    private String date;
    @SerializedName("image")
    private String image;


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
}
